package sample.audioserver;

import sample.audiocommunication.Message;
import sample.audiocommunication.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//import org.teleal.cling.support.igd.PortMappingListener;
//import org.teleal.cling.support.model.PortMapping;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 * opens a socket, listens for incoming connections, and creates a
 * ClientConnection for each client. also creates a BroadcastThread that passes
 * messages from the broadcastQueue to all the instances of ClientConnection
 *
 * @author dosse
 */
public class AudioServer {
    
    private ArrayList<Message> broadCastQueue = new ArrayList<Message>();    
    private ArrayList<AudioClientConnection> clients = new ArrayList<AudioClientConnection>();
    private int port;
    
    public static void main(String s[]) {
    	try {
			new AudioServer(7801);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void addToBroadcastQueue(Message m) { //add a message to the broadcast queue. this method is used by all ClientConnection instances
        try {
            broadCastQueue.add(m);
        } catch (Throwable t) {
            //mutex error, try again
            Utils.sleep(1);
            addToBroadcastQueue(m);
        }
    }
    private ServerSocket serverSocket;
    
    public AudioServer(int port) throws Exception{
        this.port = port;

        try {
            serverSocket = new ServerSocket(port); //listen on specified port
        } catch (IOException ex) {
            throw new Exception("Error "+ex);
        }
        new BroadcastThread().start(); //create a BroadcastThread and start it
        for (;;) { //accept all incoming connection
            try {
                Socket socket = serverSocket.accept();
                AudioClientConnection audioClientConnection = new AudioClientConnection(this, socket); //create a ClientConnection thread
                audioClientConnection.start();
                addToClients(audioClientConnection);
            } catch (IOException ex) {
            }
        }
    }

    private void addToClients(AudioClientConnection cc) {
        try {
            clients.add(cc); //add the new connection to the list of connections
        } catch (Throwable t) {
            //mutex error, try again
            Utils.sleep(1);
            addToClients(cc);
        }
    }

    /**
     * broadcasts messages to each ClientConnection, and removes dead ones
     */
    private class BroadcastThread extends Thread {
        
        public BroadcastThread() {
        }
        
        @Override
        public void run() {
            for (;;) {
                try {
                    ArrayList<AudioClientConnection> toRemove = new ArrayList<AudioClientConnection>(); //create a list of dead connections
                    for (AudioClientConnection audioClientConnection : clients) {
                        if (!audioClientConnection.isAlive()) { //connection is dead, need to be removed
                            toRemove.add(audioClientConnection);
                        }
                    }
                    clients.removeAll(toRemove); //delete all dead connections
                    if (broadCastQueue.isEmpty()) { //nothing to send
                        Utils.sleep(10); //avoid busy wait
                        continue;
                    } else { //we got something to broadcast
                        Message message = broadCastQueue.get(0);
                        for (AudioClientConnection audioClientConnection : clients) { //broadcast the message
                            if (audioClientConnection.getClientId() != message.getChId()) {
                            	audioClientConnection.addToQueue(message);
                            }
                        }
                        broadCastQueue.remove(message); //remove it from the broadcast queue
                    }
                } catch (Throwable t) {
                    //mutex error, try again
                }
            }
        }
    }
}
