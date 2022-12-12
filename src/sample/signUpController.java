package sample;


import Yahtzee.app.App;
import Yahtzee.app.App.Returns;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class signUpController {
	@FXML private TextField nameField;
	@FXML private TextField lastNameField;
	@FXML private TextField emailField;
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	@FXML private TextField confirmPasswordField;
	@FXML private Button signUpButton;
	@FXML private Label confirmationLabel;
	
	@FXML 
	private void signUpAction() {
		if(passwordField.getText().equals(confirmPasswordField.getText())) {
			
	
			App app = new App();
			Returns ret = app.createUser(usernameField.getText(), passwordField.getText(), nameField.getText(),lastNameField.getText(),emailField.getText());
			if(!ret.errorExists) {
				if(!ret.returnedBoolValue) {
					confirmationLabel.setVisible(true);
					confirmationLabel.setTextFill(Color.LIMEGREEN);
					confirmationLabel.setText("User creation successful! Now you can log in with your new account.");
				}
				else {
					confirmationLabel.setVisible(true);
					confirmationLabel.setTextFill(Color.RED);
					confirmationLabel.setText("Username taken.\nPlease try another username");
				}
			}
			else {
				confirmationLabel.setVisible(true);
				confirmationLabel.setTextFill(Color.RED);
				confirmationLabel.setText("There was an error connecting with the server! Please try again later!");
				System.out.println(ret.error);
			}
		}
	
	else {
		confirmationLabel.setVisible(true);
		confirmationLabel.setTextFill(Color.RED);
		confirmationLabel.setText("Password and confirm password are not the same!");
	}
		}
	static Boolean CONTROLPressed = false;
	static Boolean BPressed = false;
	@FXML
	private void enterPressed() {
		Main.primaryStage.getScene().getFocusOwner().setOnKeyPressed(e->{
			if(e.getCode() == KeyCode.ENTER) {
				signUpButton.fire();
			}
		
		});
		
		
		
		
//		  System.out.println(user.getOnKeyPressed());
//		  System.out.println(user.getOnKeyReleased());
//		  System.out.println(user.getOnKeyTyped());
//		  if(e.getCode().equals(KeyCode.ENTER)) {
//			  System.out.println("Enter pressed!");
//		  }
	  }
}
