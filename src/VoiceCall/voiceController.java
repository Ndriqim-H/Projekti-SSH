package VoiceCall;

import javafx.scene.control.Button;

public class voiceController {

    public Button CallButton;

    public void beginCall() {
        CallButton.getStyleClass().removeAll("call");
        CallButton.getStyleClass().add("endCall");
    }
}
