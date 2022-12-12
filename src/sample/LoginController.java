package sample;



import Yahtzee.app.App;
import Yahtzee.app.App.Returns;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/** Controls the login screen */
public class LoginController {
  @FXML private TextField user;
  @FXML private TextField password;
  @FXML private Button loginButton;
  @FXML private Label authLabel;
  
  
  
  
  public void initialize() {
	  user.setOnKeyPressed(e->{
		  if(e.getCode().equals(KeyCode.ENTER))
			  loginButton.fire();
	  });;
	  password.setOnKeyPressed(e->{
		  if(e.getCode().equals(KeyCode.ENTER))
			  loginButton.fire();
	  });;
  }
  public void loginClicked() {
	  App app = new App();
	  
	  if(!(user.getText().isEmpty() || password.getText().isEmpty())) {
		  
		  Returns ret = app.verifyPassword(user.getText(), password.getText());
		  
		  if(!(ret.errorExists))
			{
				if(ret.returnedBoolValue) {
					authLabel.setVisible(true);
					authLabel.setText("Success!");
					
					Parent root;
					
					try {
						authLabel.setVisible(false);
						LojaController.username = user.getText();
						root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
						Main.primaryStage.setScene(new Scene(root));
//						
////						LojaController cont = new LojaController();
//						
////						cont.userString = user.getText();
//					
////						Controller.setUsername(user.getText());
////						Controller rootController = new Controller();
////				        rootController.usernameLabel.setText(user.getText());
////						Controller cont = new Controller();
////						cont.usernameLabel.setText(Controller.getUsername());
//						
////						cont.usernameLabel.setText(user.getText());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					authLabel.setVisible(true);
					authLabel.setText("Username or password are incorrect!");
				}
			}
			else {
				authLabel.setVisible(true);
				authLabel.setTextFill(Color.RED);
				authLabel.setText("Could not connect to server!\nError: "+ret.error);
				System.out.println(ret.error);
			}
	  }
  }
	  
//  public void initManager(final LoginManager loginManager) {
//    loginButton.setOnAction(new EventHandler<ActionEvent>() {
//      @Override public void handle(ActionEvent event) {
//        String sessionID = authorize();
//        if (sessionID != null) {
//          loginManager.authenticated(sessionID);
//        }
//      }
//    });
//  }

  /**
   * Check authorization credentials.
   * 
   * If accepted, return a sessionID for the authorized session
   * otherwise, return null.
   */   
  private String authorize() {
    return 
      "open".equals(user.getText()) && "sesame".equals(password.getText()) 
            ? generateSessionID() 
            : null;
  }
  
  private static int sessionID = 0;

  private String generateSessionID() {
    sessionID++;
    return "xyzzy - session " + sessionID;
  }
  @FXML
  private void enterPressed(KeyEvent e) {
//	  System.out.println(user.getOnKeyPressed());
//	  System.out.println(user.getOnKeyReleased());
//	  System.out.println(user.getOnKeyTyped());
//	  if(e.getCode().equals(KeyCode.ENTER)) {
//		  System.out.println("Enter pressed!");
//	  }
  }
  
 
  
}
