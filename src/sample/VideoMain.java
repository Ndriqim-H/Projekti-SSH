package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VideoMain extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        String thisClientUsername = "This client's username";
        Parent root = FXMLLoader.load(getClass().getResource("video.fxml"));
        primaryStage.setTitle(thisClientUsername);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }


    public static void main(String[] args) {
    	System.out.println(args);
        launch(args);
    }
}
