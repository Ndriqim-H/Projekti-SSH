package Yahtzee.app;

import Yahtzee.service.serveClientGrpc;
import Yahtzee.service.Client.Password;
import Yahtzee.service.Client.Valid;
import io.grpc.*;

/**
 * Hello world!
 */
public final class App {
    public App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:7070").usePlaintext().build();
        serveClientGrpc.serveClientBlockingStub client = serveClientGrpc.newBlockingStub(channel);
        Valid authentification = client
                .verifyPassword(Password.newBuilder().setUsername("DaBest").setPassword("Ndriq159").build());
        System.out.println(authentification);
        if (authentification.getValid()) {
            System.out.println("Logged in!");
        } else {
            System.out.println("Wrong username or password!");
        }

    }
}
