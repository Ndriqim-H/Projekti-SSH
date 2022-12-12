package VideoCall;



import javafx.application.Platform;
import javafx.scene.control.Button;

public class videoController {

    public Button CallButton;

    public void beginCall() {
        CallButton.getStyleClass().removeAll("call");
        CallButton.getStyleClass().add("endCall");
    }

	public static void exitApplication() {
		// TODO Auto-generated method stub
		Platform.exit();
	}
}
