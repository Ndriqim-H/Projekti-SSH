package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;

public class LoginCont {
    public Pane loginPlatform;
    public VBox ChangingVBox;
    public VBox SliderVBox, login, signup, forgot;
    public ImageView backgroundImage;
    public Button signUpButton, forgotPasswordButton;
    public  Button logInButton;

    //me dit ku osht VBox-i
    private boolean isChangingVBoxLeft = true;

    @FXML
    void initialize() {
        Button btnSignUp = (Button) SliderVBox.lookup("#signUpButton");
        btnSignUp.setOnAction(this::goToSignUp);
        Button btnForgotPassword = (Button) SliderVBox.lookup("#forgotPasswordButton");
//        btnForgotPassword.setOnAction(this::goToForgotPassword);
        Button btnLogIn = (Button) SliderVBox.lookup("#logInButton");
        btnLogIn.setOnAction(this::goToLogIn);
    }

    private void goToSignUp(ActionEvent actionEvent){
        //new image
        URL img = getClass().getResource("../sample/pink.gif");

        FadeTransition fo = new FadeTransition(Duration.millis(650), SliderVBox);
        fo.setFromValue(1);
        fo.setToValue(0);
        fo.play();

        SliderVBox.setStyle("-fx-border-color: pink; -fx-background-image: url('sample/white1.gif');");

        if(isChangingVBoxLeft == true){

            isChangingVBoxLeft=false;


            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(SliderVBox.getPrefWidth());
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();


            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(false);
                        logInButton.setText("Log-In?");
                        signUpButton.setDisable(true);
                        signUpButton.setText("Preparing fun time...");
//                        forgotPasswordButton.setDisable(false);
//                        forgotPasswordButton.setText("Forgot Password?");

                        backgroundImage.setImage(new Image(img.toExternalForm()));

                        login.setVisible(false);
                        login.setManaged(false);
                        forgot.setVisible(false);
                        forgot.setManaged(false);
                        signup.setVisible(true);
                        signup.setManaged(true);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX()-ChangingVBox.getPrefWidth());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        } else {
            isChangingVBoxLeft=true;

            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(0);
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(false);
                        logInButton.setText("Log-In?");
                        signUpButton.setDisable(true);
                        signUpButton.setText("Preparing fun time...");
                        forgotPasswordButton.setDisable(false);
                        forgotPasswordButton.setText("Forgot Password?");

                        login.setVisible(false);
                        login.setManaged(false);
                        forgot.setVisible(false);
                        forgot.setManaged(false);
                        signup.setVisible(true);
                        signup.setManaged(true);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        backgroundImage.setImage(new Image(img.toExternalForm()));
                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        }
    }

    private void goToForgotPassword(ActionEvent actionEvent){
        //new image
        URL img = getClass().getResource("../sample/yellow.gif");

        FadeTransition fo = new FadeTransition(Duration.millis(650), SliderVBox);
        fo.setFromValue(1);
        fo.setToValue(0);
        fo.play();

        SliderVBox.setStyle("-fx-border-color: yellow; -fx-background-image: url('sample/white1.gif');");

        if(isChangingVBoxLeft == true){

            isChangingVBoxLeft=false;


            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(SliderVBox.getPrefWidth());
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();


            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(false);
                        logInButton.setText("Log-In?");
                        signUpButton.setDisable(false);
                        signUpButton.setText("Sign-Up?");
                        forgotPasswordButton.setDisable(true);
                        forgotPasswordButton.setText("Ru-Roh!");

                        backgroundImage.setImage(new Image(img.toExternalForm()));

                        //Ndrro layout
                        login.setVisible(false);
                        login.setManaged(false);
                        forgot.setVisible(true);
                        forgot.setManaged(true);
                        signup.setVisible(false);
                        signup.setManaged(false);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX()-ChangingVBox.getPrefWidth());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        } else {
            isChangingVBoxLeft=true;

            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(0);
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(false);
                        logInButton.setText("Log-In?");
                        signUpButton.setDisable(false);
                        signUpButton.setText("Sign-Up?");
                        forgotPasswordButton.setDisable(true);
                        forgotPasswordButton.setText("Ru-Roh!");

                        login.setVisible(false);
                        login.setManaged(false);
                        forgot.setVisible(true);
                        forgot.setManaged(true);
                        signup.setVisible(false);
                        signup.setManaged(false);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        backgroundImage.setImage(new Image(img.toExternalForm()));
                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        }
    }

    private void goToLogIn(ActionEvent actionEvent){
        //new image
        URL img = getClass().getResource("../sample/green.gif");
        System.out.println(img);
        FadeTransition fo = new FadeTransition(Duration.millis(650), SliderVBox);
        fo.setFromValue(1);
        fo.setToValue(0);
        fo.play();

        SliderVBox.setStyle("-fx-border-color: green; -fx-background-image: url('sample/white1.gif');");

        if(isChangingVBoxLeft == true){

            isChangingVBoxLeft=false;


            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(SliderVBox.getPrefWidth());
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();


            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(true);
                        logInButton.setText("Let's Roll!");
                        signUpButton.setDisable(false);
                        signUpButton.setText("Sign-Up?");
                        forgotPasswordButton.setDisable(false);
                        forgotPasswordButton.setText("Forgot Password?");

                        backgroundImage.setImage(new Image(img.toExternalForm()));

                        //Ndrro layout
                        login.setVisible(true);
                        login.setManaged(true);
                        forgot.setVisible(false);
                        forgot.setManaged(false);
                        signup.setVisible(false);
                        signup.setManaged(false);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX()-ChangingVBox.getPrefWidth());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        } else {
            isChangingVBoxLeft=true;

            TranslateTransition changePlace = new TranslateTransition(Duration.seconds(1.3), ChangingVBox);
            changePlace.setToX(0);
            changePlace.play();
            FadeTransition fout = new FadeTransition(Duration.millis(650), ChangingVBox);
            fout.setFromValue(1);
            fout.setToValue(0);
            fout.play();

            FadeTransition fob = new FadeTransition(Duration.millis(650), backgroundImage);
            fob.setFromValue(1);
            fob.setToValue(0);
            fob.play();

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae ->{

                        //off kti buttoni, on tjerve
                        logInButton.setDisable(true);
                        logInButton.setText("Let's Roll!");
                        signUpButton.setDisable(false);
                        signUpButton.setText("Sign-Up?");
//                        forgotPasswordButton.setDisable(false);
//                        forgotPasswordButton.setText("Forgot Password?");

                        //Ndrro Layout
                        login.setVisible(true);
                        login.setManaged(true);
                        forgot.setVisible(false);
                        forgot.setManaged(false);
                        signup.setVisible(false);
                        signup.setManaged(false);
                        FadeTransition fi = new FadeTransition(Duration.millis(650), ChangingVBox);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        TranslateTransition changeSliderPlace = new TranslateTransition(Duration.seconds(1.3), SliderVBox);
                        changeSliderPlace.setFromX(loginPlatform.getLayoutX());
                        changeSliderPlace.play();

                        FadeTransition fin = new FadeTransition(Duration.millis(1300), SliderVBox);
                        fin.setFromValue(0);
                        fin.setToValue(1);
                        fin.play();

                        backgroundImage.setImage(new Image(img.toExternalForm()));
                        FadeTransition fib = new FadeTransition(Duration.millis(650), backgroundImage);
                        fib.setFromValue(0);
                        fib.setToValue(1);
                        fib.play();

                    }
            ));
            timeline.play();
        }
    }
}