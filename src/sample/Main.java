package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception{

    	
    	
		stage.setResizable(true);
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage=stage;
        primaryStage.setScene(new Scene(root));
//        primaryStage.setTitle("Yahtzee app");
//        primaryStage.setScene(new Scene(root));
		
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
