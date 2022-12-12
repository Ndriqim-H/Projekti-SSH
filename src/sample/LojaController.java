package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import VideoCall.videoController;
import Yahtzee.app.App;
import Yahtzee.app.App.Returns;
import Yahtzee.service.Client.Username;



public class LojaController implements Initializable{
	public static String username;
	private static boolean gRpcError;
	private static int lastScore;
	public static Label usernameLabel = new Label("Username");
	private static Label tempUsernameLabel;
	private WebSocketClient cc;
    public AnchorPane root;
    public VBox scene;
    public Button swapButton;
    public Pane Loja;
    public Pane Msg;
    public Button optionsBtn;
    private static boolean firstTime = true;
    @FXML
    private TextArea Chat;
    @FXML
    private Button btnSend;
    @FXML
    private Button connect;
    @FXML
    private TextField message;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField oldPasswordField;
    @FXML private Label optionsConfirmLabel;
    @FXML public Button videoButton;
    
    //me dit ne cilen anë jena
    private boolean left = true;
    private static boolean isOptions = false;
//    private boolean optionsBool = false;
    
//    public Controller() {
//		// TODO Auto-generated constructor stub
//    	usernameLabel.setText(username);
//	}

//    protected void initialize() {
//    	usernameLabel.setText("Hello");
//    	setUsername("Ndriqa");
//	}
//    
    public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//    	if()
    	if(!isOptions) {
    		optionsVBox.getChildren().add(usernameLabel);	
    	}
    	if(usernameLabel!=null && firstTime) {
    		
    		firstTime = false;
    		usernameLabel.setTextFill(Color.RED);
    		putScoreToLabel();
    	}
    	
	}
    @FXML private void changePassword() {
    	App app = new App();
    	Returns ret = app.setPassword(username, oldPasswordField.getText(), newPasswordField.getText());
    	if(!ret.errorExists) {
    		if(ret.returnedBoolValue) {
    			optionsConfirmLabel.setText("Password has been successfully updated!");
    		optionsConfirmLabel.setTextFill(Color.GREEN);
    		optionsConfirmLabel.setVisible(true);
    		}
    		
    		else {
    			optionsConfirmLabel.setText("Current password is not valid!");
        		optionsConfirmLabel.setTextFill(Color.RED);
        		optionsConfirmLabel.setVisible(true);
    		}
    	}
    	else {
    		optionsConfirmLabel.setText("Password was not updated!\nCouldn't connect to server!");
    		optionsConfirmLabel.setTextFill(Color.RED);
    		optionsConfirmLabel.setVisible(true);
    	}
    }
    
    private void putScoreToLabel() {
    	App app = new App();
//    	Returns ret1 = app.setScore(username, 48);
    	Returns ret = app.getScore(username);
    	if(!ret.errorExists) {
    		
    		usernameLabel.setText("Username: "+username+"\nHigh Score: "+ ret.returnedIntArray[1] + "\nLast Score: "+ret.returnedIntArray[0]);
//    		System.out.println(usernameLabel);
    		gRpcError = false;
    		lastScore = ret.returnedIntArray[0];
    	}
    	else {
    		Button retryButton = new Button("Retry...");
    		retryButton.setOnAction(e ->{
    			optionsVBox.getChildren().remove(retryButton);
    			putScoreToLabel();
    			
    		});;
    		usernameLabel.setText("Error! Couldn't get score for: "+username +"\nError: "+ ret.error);
    		optionsVBox.getChildren().add(retryButton);
    		gRpcError = true;
		}
    	
    }
    
    
    public void swap(){
    	swapButton.setDisable(true);

        if(left){
//        	usernameLabel.setText(username);
//        	username.setText("Left");
            //bone Msg visible ama e tejdukshme
            Msg.setOpacity(0);
            Msg.setVisible(true);

            //tranzit prej majt ne te djatht te panet-it perpara
            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.3), scene);
            translate.setToX(scene.getLayoutX() + (root.getPrefWidth() - scene.getPrefWidth()));
            translate.play();
            translate.setOnFinished(e -> swapButton.setDisable(false));

            //le me shtyp prap butonin per mu ndrru skena
            left=false;
            swapButton.setText("Play!");

            //largo skenen e lojes kur ndrrohet pozita e butonave
            //bonja fade away
            FadeTransition fo = new FadeTransition(Duration.millis(650), Loja);
            fo.setFromValue(1);
            fo.setToValue(0);
            fo.play();

            //levize djathtas majtas gjate kohes qe ja bon fade
            TranslateTransition fadeleft = new TranslateTransition(Duration.seconds(0.65), Loja);
            fadeleft.setToX(Loja.getLayoutX() - (root.getPrefWidth()/2));
            fadeleft.play();
            
            //fute ne sken msgs edhe prit gjysen e kohes para se mu shfaq
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{
                            TranslateTransition faderight = new TranslateTransition(Duration.seconds(0.65), Msg);
                            faderight.setFromX(root.getPrefWidth() / 2);
                            faderight.setToX(scene.getLayoutX());
                            faderight.play();
                            FadeTransition fi = new FadeTransition(Duration.millis(650), Msg);
                            fi.setFromValue(0);
                            fi.setToValue(1);
                            fi.play();

                            //Hjeke Game node qe me mujt me kliku mi Msg node
                            Loja.setVisible(false);
                            Loja.managedProperty().bind(Loja.visibleProperty());
                    }
            ));
            timeline.play();

        }
        else if(!left){
//        	username.setText("Right");
            //tranzit prej djatht ne te majt te panet-it perpara
            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.3), scene);
            translate.setToX(scene.getLayoutX());
            translate.play();
            translate.setOnFinished(e -> swapButton.setDisable(false));

            //le me shtyp prap butonin per mu ndrru skena
            left=true;
            swapButton.setText("Chat...");

            //largo skenen e Msg kur ndrrohet pozita e butonave
            //bonja fade away
            FadeTransition fo = new FadeTransition(Duration.millis(650), Msg);
            fo.setFromValue(1);
            fo.setToValue(0);
            fo.play();

            //levize djathtas majtas gjate kohes qe ja bon fade
            TranslateTransition fadeleft = new TranslateTransition(Duration.seconds(0.65), Msg);
            fadeleft.setToX(Msg.getLayoutX() + (root.getPrefWidth()/2));
            fadeleft.play();

            //fute ne sken e lojes edhe prit gjysen e kohes para se mu shfaq
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(650),
                    ae ->{
                        TranslateTransition faderight = new TranslateTransition(Duration.seconds(0.65), Loja);
                        faderight.setFromX(Loja.getLayoutX() - (root.getPrefWidth()/2));
                        faderight.setToX(Loja.getPrefWidth());
                        faderight.play();
                        FadeTransition fi = new FadeTransition(Duration.millis(650), Loja);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();

                        //Kthe Game node per me mujt me interaktu
                        Loja.setVisible(true);
                        Loja.managedProperty().bind(Loja.visibleProperty());
                    }
            ));
            timeline.play();
            if(gRpcError)
            	putScoreToLabel();
        }
    }
    public void ReDoGame(){
    	
    	disableCheckBox();
        throwNum = 0;
        totalSum = 0;
        finalRezultati = 0;
        onesCheckdisable = false;
        twosCheckdisable = false;
        threesCheckdisable = false;
        foursCheckdisable = false;
        fivesCheckdisable = false;
        sixesCheckdisable = false;
        chanceCheckdisable = false;
        threeKindsCheckdisable = false;
        fourKindsCheckdisable = false;
        twoPairCheckdisable = false;
        fullHouseCheckdisable = false;
        littleSCheckdisable = false;
        bigSCheckdisable = false;
        yahtzeeCheckdisable = false;
        smallOnes = false;
        smallTwos = false;
        smallThrees = false;
        smallFours = false;
        smallFives = false;
        smallSixes = false;
        smallChance = false;
        smallSumCheck = 0;
        bigThree = false;
        bigFour = false;
        bigTwoPair = false;
        bigFullH = false;
        bigLS = false;
        bigBS = false;
        bigYahtzee = false;
        bigSumCheck = 0;
        TotalCheck.setText("");
        BonusCheck.setText("");
        RollButton.setDisable(false);
        RollButton.setText("Roll the dices");
        URL startingDice = getClass().getResource("../Loja/Dices/beforeRollDice.png");
        dice1.setImage(new Image(startingDice.toExternalForm()));
        dice2.setImage(new Image(startingDice.toExternalForm()));
        dice3.setImage(new Image(startingDice.toExternalForm()));
        dice4.setImage(new Image(startingDice.toExternalForm()));
        dice5.setImage(new Image(startingDice.toExternalForm()));
        
        onesCheck.setSelected(false);
        twosCheck.setSelected(false);
        threesCheck.setSelected(false);
        foursCheck.setSelected(false);
        fivesCheck.setSelected(false);
        sixesCheck.setSelected(false);
        chanceCheck.setSelected(false);
        ThreeKindsCheck.setSelected(false);
        FourKindsCheck.setSelected(false);
        TwoPairCheck.setSelected(false);
        FullHouseCheck.setSelected(false);
        LittleSCheck.setSelected(false);
        BigSCheck.setSelected(false);
        YahtzeeCheck.setSelected(false);
    }


    public void Call(ActionEvent actionEvent) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("/VoiceCall/voice.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    public void Video(ActionEvent actionEvent) throws IOException {
//        Parent part = FXMLLoader.load(getClass().getResource("/VoiceCall/voice.fxml"));
    	videoButton.setDisable(true);
		Parent part = FXMLLoader.load(getClass().getResource("video.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            VideoController.exitApplication();
            videoButton.setDisable(false);
//            videoButton.setText("Hello");
//            System.exit(0);
            
        });
        stage.show();
        
        
//    	VideoMain.main(args);
//    	VideoMain vid = new VideoMain();
    	
    }
    
    //=================================================
    

    public Button RollButton;
    public ImageView dice1;
    public ImageView dice2;
    public ImageView dice3;
    public ImageView dice4;
    public ImageView dice5;
    public CheckBox onesCheck;
    public CheckBox twosCheck;
    public CheckBox threesCheck;
    public CheckBox foursCheck;
    public CheckBox fivesCheck;
    public CheckBox sixesCheck;
    public CheckBox chanceCheck;
    public CheckBox ThreeKindsCheck;
    public CheckBox FourKindsCheck;
    public CheckBox TwoPairCheck;
    public CheckBox FullHouseCheck;
    public CheckBox LittleSCheck;
    public CheckBox BigSCheck;
    public CheckBox YahtzeeCheck;
    public Label BonusCheck;
    public Label TotalCheck;
    public VBox optionsVBox;
    public VBox change;
    public VBox options;
    
    //variablat
    //numri i gjuajtejeve (deri ne 3)
    private int throwNum = 0;
    //na duhet ni array me vlerat e 5 gjujtjeve, e perdorim si passed variabel te konstruktort e klasave per kalkulime
    private int[] rezultati = new int[5];
    //Shuma finale
    private int totalSum = 0;
    //Variabla e shumes finale ne Game-Over
    private int finalRezultati = 0;

    //per me i bo permanent disable checkboxat
    private boolean onesCheckdisable = false;
    private boolean twosCheckdisable = false;
    private boolean threesCheckdisable = false;
    private boolean foursCheckdisable = false;
    private boolean fivesCheckdisable = false;
    private boolean sixesCheckdisable = false;
    private boolean chanceCheckdisable = false;
    private boolean threeKindsCheckdisable = false;
    private boolean fourKindsCheckdisable = false;
    private boolean twoPairCheckdisable = false;
    private boolean fullHouseCheckdisable = false;
    private boolean littleSCheckdisable = false;
    private boolean bigSCheckdisable = false;
    private boolean yahtzeeCheckdisable = false;

    //variablat per bonus, nese jon true krejt ja jep ni bonus, 35 per Small, edhe Big 100;
    //per small ose kolona e par, jon tnevojshme me i dit krejt a i ka check
    //se nese e ka mrri me pak rolls, munen me ju shtu disa her bonusi
    private boolean smallOnes = false;
    private boolean smallTwos = false;
    private boolean smallThrees = false;
    private boolean smallFours = false;
    private boolean smallFives = false;
    private boolean smallSixes = false;
    private boolean smallChance = false;
    //kushti osht qe me pas shumen kolona e par mbi 63
    private int smallSumCheck = 0;
    //per big ose kolona e dyt
    private boolean bigThree = false;
    private boolean bigFour = false;
    private boolean bigTwoPair = false;
    private boolean bigFullH = false;
    private boolean bigLS = false;
    private boolean bigBS = false;
    private boolean bigYahtzee = false;
    private int bigSumCheck = 0;

    //klasat
    Loja.Rezultatet.ONES ones;
    Loja.Rezultatet.TWOS twos;
    Loja.Rezultatet.THREES threes;
    Loja.Rezultatet.FOURS fours;
    Loja.Rezultatet.FIVES fives;
    Loja.Rezultatet.SIXES sixes;
    Loja.Rezultatet.CHANCE chance;
    Loja.Rezultatet.THREEKINDS threekinds;
    Loja.Rezultatet.FOURKINDS fourkinds;
    Loja.Rezultatet.TWOPAIR twopair;
    Loja.Rezultatet.FULLHOUSE fullhouse;
    Loja.Rezultatet.LITTLES littles;
    Loja.Rezultatet.BIGS bigs;
    Loja.Rezultatet.YAHTZEE yahtzee;

    //variabla per hover per button
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #c3d0d4; -fx-border-color: #8cb48c; -fx-border-width: 5; -fx-background-radius: 17; -fx-border-radius: 15;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #c3d0d4; -fx-border-color: #8cb48c; -fx-border-width: 5; -fx-background-radius: 17; -fx-border-radius: 15;";
    
    //butoni me lu lojen Roll the Dices
    public void rollDice() {
        //Ndrysho foton per 6 imageViews me bo qe po rrotullohet zari
        URL rollingDice = getClass().getResource("../Loja/Dices/DiceRolling.gif");
        dice1.setImage(new Image(rollingDice.toExternalForm()));
        dice2.setImage(new Image(rollingDice.toExternalForm()));
        dice3.setImage(new Image(rollingDice.toExternalForm()));
        dice4.setImage(new Image(rollingDice.toExternalForm()));
        dice5.setImage(new Image(rollingDice.toExternalForm()));

        //Nese bohen 3 gjujtje, mos e le me gjujt deri sa te bon select ni rezultat
        throwNum++;
        if(throwNum==3){ RollButton.setDisable(true); }
        else {RollButton.setDisable(false);}

        //Le gif me lujt per 2.5 sekonda
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        //Thirre klasen zari
                        Dice Dice = new Dice(6);

                        //Per secilin zar (5 max) rrotullo 1 her
                        for(int i = 1; i<=5 ; i++){
                            //funksioni rrotullo zarin
                            int diceVal = Dice.roll();

                            //Ruje rez e hedhjes ne array
                            rezultati[i-1]=diceVal;

                            //Ndrysho foton nbaz cilit zar jemi (i) edhe cili numer ka ra (case)
                            switch (diceVal) {
                                case 1:
                                    URL diceSide1 = getClass().getResource("../Loja/Dices/Side1.png");
                                    if(i==1){dice1.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide1.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide1.toExternalForm()));}
                                    break;
                                case 2:
                                    URL diceSide2 = getClass().getResource("../Loja/Dices/Side2.png");
                                    if(i==1){dice1.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide2.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide2.toExternalForm()));}
                                    break;
                                case 3:
                                    URL diceSide3 = getClass().getResource("../Loja/Dices/Side3.jpg");
                                    if(i==1){dice1.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide3.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide3.toExternalForm()));}
                                    break;
                                case 4:
                                    URL diceSide4 = getClass().getResource("../Loja/Dices/Side4.jpg");
                                    if(i==1){dice1.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide4.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide4.toExternalForm()));}
                                    break;
                                case 5:
                                    URL diceSide5 = getClass().getResource("../Loja/Dices/Side5.png");
                                    if(i==1){dice1.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide5.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide5.toExternalForm()));}
                                    break;
                                case 6:
                                    URL diceSide6 = getClass().getResource("../Loja/Dices/Side6.png");
                                    if(i==1){dice1.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide6.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide6.toExternalForm()));}
                                    break;
                            }
                        }
                    }
                    //koha qe pret mu kry gif
                }, 2500
        );
        //Nuk e shpreh rezultatin deri sa tkryhet animacioni
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2600),
                ae -> {
                    //mas animacionit kur kryhet, thirri klasat me percaktu rez, me leju checkboxat mu click
                    //edhe me display textin ne baz rez qe na kthehet
                    ones = new Loja.Rezultatet.ONES(rezultati);
                    onesCheckbox();
                    twos = new Loja.Rezultatet.TWOS(rezultati);
                    twosCheckbox();
                    threes = new Loja.Rezultatet.THREES(rezultati);
                    threesCheckbox();
                    fours = new Loja.Rezultatet.FOURS(rezultati);
                    foursCheckbox();
                    fives = new Loja.Rezultatet.FIVES(rezultati);
                    fivesCheckbox();
                    sixes = new Loja.Rezultatet.SIXES(rezultati);
                    sixesCheckbox();
                    chance = new Loja.Rezultatet.CHANCE(rezultati);
                    chanceCheck();
                    threekinds = new Loja.Rezultatet.THREEKINDS(rezultati);
                    threekindsCheck();
                    fourkinds = new Loja.Rezultatet.FOURKINDS(rezultati);
                    fourkindsCheck();
                    twopair = new Loja.Rezultatet.TWOPAIR(rezultati);
                    twopairCheck();
                    fullhouse = new Loja.Rezultatet.FULLHOUSE(rezultati);
                    fullhouseCheck();
                    littles = new Loja.Rezultatet.LITTLES(rezultati);
                    littlesCheck();
                    bigs = new Loja.Rezultatet.BIGS(rezultati);
                    bigsCheck();
                    yahtzee = new Loja.Rezultatet.YAHTZEE(rezultati);
                    yahtzeeCheck();
                }
                ));
        //play bohet tnjejten koh me pauzen e maperparshme, 0.1 sekonda ma von ja nis me i bo display edhe claculate
        timeline.play();

    }

    //Kur shtypet ni CheckBox
    //merrja shumen, shto ne total result, ndrro textin, bone permanent disable qat checkbox
    //gjithashtu i bon disable krejt checkboxat tjer edhe ja hjek rezultatet
    //kur e shtyp ni checkbox ja bon number of roll back to 0 qe me mujt me gju edhe 3 her
    //niher kalkulohet bonusi, bonusi aktivizohet veq kur krejt checkboxat e kolones jon check
    public void resultONESClick(){

        //per bonus
        smallOnes=true;
        smallSumCheck+=ones.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + ones.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        onesCheckdisable = true;

        //re-roll
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultTWOSClick(){

        //per bonus
        smallTwos=true;
        smallSumCheck+=twos.getShuma();
        showBonus();

        //per shumen totale
        totalSum = totalSum + smallBonus() + twos.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        twosCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultTHREESClick(){

        //per bonus
        smallThrees=true;
        smallSumCheck+=threes.getShuma();
        showBonus();

        //me kalkulu shumen
        totalSum = totalSum + smallBonus() + threes.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        threesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultFOURSClick(){

        //per bonus
        smallFours=true;
        smallSumCheck+=fours.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + fours.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        foursCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultFIVESClick(){

        //per bonus
        smallFives=true;
        smallSumCheck+=fives.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + fives.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fivesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultSIXESClick(){

        //per bonus
        smallSixes=true;
        smallSumCheck+=sixes.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + sixes.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        sixesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultCHANCEClick(){

        //per bonus
        smallChance=true;
        smallSumCheck+=chance.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + chance.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        chanceCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void result3OAKClick(){

        //per bonus
        bigThree=true;
        bigSumCheck+=threekinds.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + threekinds.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        threeKindsCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void result4OAKClick(){

        //per bonus
        bigFour=true;
        bigSumCheck+=fourkinds.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + fourkinds.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fourKindsCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void result2PClick(){

        //per bonus
        bigTwoPair=true;
        bigSumCheck+=twopair.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + twopair.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        twoPairCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultFULLHOUSEClick(){

        //per bonus
        bigFullH=true;
        bigSumCheck+=fullhouse.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + fullhouse.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fullHouseCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultLITTLESClick(){

        //per bonus
        bigLS=true;
        bigSumCheck+=littles.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + littles.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        littleSCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultBIGSClick(){

        //per bonus
        bigBS=true;
        bigSumCheck+=bigs.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + bigs.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        bigSCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }
    public void resultYAHTZEEClick(){

        //per bonus
        bigYahtzee=true;
        bigSumCheck+=yahtzee.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + yahtzee.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        yahtzeeCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();

        //check per Game-Over
        finalRez();
    }


    //Kur shtypet butoni roll, funskionet i kalkulojn shumat e pikve per opsione edhe i bojn enable opsionet
    //nese ni opsion e ka disable true smunet per 2ten her me u ri-shtyp
    public void onesCheckbox(){
        if(onesCheckdisable==false){
            onesCheck.setDisable(false);
            int onesSum = ones.getShuma();
            onesCheck.setText(String.valueOf(onesSum));
        }
    }
    public void twosCheckbox(){
        if(twosCheckdisable==false){
            twosCheck.setDisable(false);
            int twosSum = twos.getShuma();
            twosCheck.setText(String.valueOf(twosSum));
        }
    }
    public void threesCheckbox(){
        if(threesCheckdisable==false){
            threesCheck.setDisable(false);
            int threesSum = threes.getShuma();
            threesCheck.setText(String.valueOf(threesSum));
        }
    }
    public void foursCheckbox(){
        if(foursCheckdisable==false){
            foursCheck.setDisable(false);
            int foursSum = fours.getShuma();
            foursCheck.setText(String.valueOf(foursSum));
        }
    }
    public void fivesCheckbox(){
        if(fivesCheckdisable==false){
            fivesCheck.setDisable(false);
            int fivesSum = fives.getShuma();
            fivesCheck.setText(String.valueOf(fivesSum));
        }
    }
    public void sixesCheckbox(){
        if(sixesCheckdisable==false){
            sixesCheck.setDisable(false);
            int sixesSum = sixes.getShuma();
            sixesCheck.setText(String.valueOf(sixesSum));
        }
    }
    public void chanceCheck(){
        if(chanceCheckdisable==false){
            chanceCheck.setDisable(false);
            int chanceSum = chance.getShuma();
            chanceCheck.setText(String.valueOf(chanceSum));
        }
    }
    public void threekindsCheck(){
        if(threeKindsCheckdisable==false){
            ThreeKindsCheck.setDisable(false);
            int threeKSum = threekinds.getShuma();
            ThreeKindsCheck.setText(String.valueOf(threeKSum));
        }
    }
    public void fourkindsCheck(){
        if(fourKindsCheckdisable==false){
            FourKindsCheck.setDisable(false);
            int fourKSum = fourkinds.getShuma();
            FourKindsCheck.setText(String.valueOf(fourKSum));
        }
    }
    public void twopairCheck(){
        if(twoPairCheckdisable==false){
            TwoPairCheck.setDisable(false);
            int twoPSum = twopair.getShuma();
            TwoPairCheck.setText(String.valueOf(twoPSum));
        }
    }
    public void fullhouseCheck(){
        if(fullHouseCheckdisable==false){
            FullHouseCheck.setDisable(false);
            int fullHSum = fullhouse.getShuma();
            FullHouseCheck.setText(String.valueOf(fullHSum));
        }
    }
    public void littlesCheck(){
        if(littleSCheckdisable==false){
            LittleSCheck.setDisable(false);
            int littleSSum = littles.getShuma();
            LittleSCheck.setText(String.valueOf(littleSSum));
        }
    }
    public void bigsCheck(){
        if(bigSCheckdisable==false){
            BigSCheck.setDisable(false);
            int bigSSum = bigs.getShuma();
            BigSCheck.setText(String.valueOf(bigSSum));
        }
    }
    public void yahtzeeCheck(){
        if(yahtzeeCheckdisable==false){
            YahtzeeCheck.setDisable(false);
            int yahtzeeSum = yahtzee.getShuma();
            YahtzeeCheck.setText(String.valueOf(yahtzeeSum));
        }
    }

    //funskioni me ja bo disable edhe me hjek tekstin
    private void disableCheckBox(){
        onesCheck.setDisable(true);
        onesCheck.setText("");
        twosCheck.setDisable(true);
        twosCheck.setText("");
        threesCheck.setDisable(true);
        threesCheck.setText("");
        foursCheck.setDisable(true);
        foursCheck.setText("");
        fivesCheck.setDisable(true);
        fivesCheck.setText("");
        sixesCheck.setDisable(true);
        sixesCheck.setText("");
        chanceCheck.setDisable(true);
        chanceCheck.setText("");
        ThreeKindsCheck.setDisable(true);
        ThreeKindsCheck.setText("");
        FourKindsCheck.setDisable(true);
        FourKindsCheck.setText("");
        TwoPairCheck.setDisable(true);
        TwoPairCheck.setText("");
        FullHouseCheck.setDisable(true);
        FullHouseCheck.setText("");
        LittleSCheck.setDisable(true);
        LittleSCheck.setText("");
        BigSCheck.setDisable(true);
        BigSCheck.setText("");
        YahtzeeCheck.setDisable(true);
        YahtzeeCheck.setText("");
    }

    //funksionet me kalkulu bonuset
    private int smallBonus(){
        if((smallOnes==true)&&(smallTwos==true)&&(smallThrees==true)&&(smallFours==true)&&(smallFives==true)
                &&(smallSixes==true)&&(smallChance==true)&&(smallSumCheck>62)){
            return 35;
        }
        else return 0;
    }
    private int bigBonus(){
        if((bigThree==true)&&(bigFour==true)&&(bigTwoPair==true)&&(bigFullH==true)&&(bigLS==true)
                &&(bigBS==true)&&(bigYahtzee==true)&&(bigSumCheck>99)){
            return 100;
        }
        else return 0;
    }

    //Display bonusin
    private void showBonus(){
        if ((smallBonus()==35)||(bigBonus()==100)){
            int bonusDisplay = smallBonus()+bigBonus();
            BonusCheck.setText(String.valueOf(bonusDisplay));
        }
    }

    //ndrro ngjyren e rez
    private void ngjyraRez() {
        if (totalSum < 26) {
            TotalCheck.setStyle("-fx-text-fill: RED");
        } else if ((totalSum > 74)&&(totalSum<126)) {
            TotalCheck.setStyle("-fx-text-fill: Blue");
        } else if (totalSum>124){
            TotalCheck.setStyle("-fx-text-fill: Green");
        } else {
            TotalCheck.setStyle("-fx-text-fill: Black");
        }
    }

    //Kqyre a jon bo check krejt checkboxat, nese po, jepe rez final qe ruhet ne DB
    public void finalRez() {
        if((smallOnes==true)&&(smallTwos==true)&&(smallThrees==true)&&(smallFours==true)&&(smallFives==true)
                &&(smallSixes==true)&&(smallChance==true)&&(bigThree==true)&&(bigFour==true)&&(bigTwoPair==true)
                &&(bigFullH==true)&&(bigLS==true) &&(bigBS==true)&&(bigYahtzee==true)){
            finalRezultati += totalSum;
            //Kur kryhet loja
            RollButton.setDisable(true);
            RollButton.setText("Game Over!");
            setScore();
        }
    }
    
    public void setScore() {
    	App app = new App();
        
        Returns ret = app.setScore(username, finalRezultati);
        if(!ret.errorExists) {
        	putScoreToLabel();
        	System.out.println("Score set Successfully!");
        	
        }
        else {
			System.out.print("There was an error updating your new score\n Error: " + ret.error);
			usernameLabel.setText("There was an error updating your new Score!");
			Button retryButton = new Button("Retry");
			retryButton.setOnAction(e->{
				optionsVBox.getChildren().remove(retryButton);
				setScore();
			});
			optionsVBox.getChildren().add(retryButton);
		}
    }
    
    //Ndrro VBox mes change password ose player options
    public void goToOptions() throws IOException{
    	FadeTransition fo = new FadeTransition(Duration.millis(650), options);
    	fo.setFromValue(0);
    	fo.setToValue(1);
    	fo.play();
    	
    	//Ndrro VBox
    	
    	tempUsernameLabel = usernameLabel;
//    	System.out.println(usernameLabel.equals(tempUsernameLabel));
    	optionsVBox.getChildren().clear();
    	isOptions = true;
    	
    	optionsVBox.getChildren().add(FXMLLoader.load(getClass().getResource("changePasswordlogOut.fxml")));
    	optionsVBox.setAlignment(Pos.CENTER);
    	
    	
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(650),
                ae ->{
                        FadeTransition fi = new FadeTransition(Duration.millis(650), change);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();
                }
        ));
        timeline.play();
    }
    
    public void goBack() throws IOException{
    	FadeTransition fo = new FadeTransition(Duration.millis(650), change);
    	fo.setFromValue(0);
    	fo.setToValue(1);
    	fo.play();
    	//Ndrro VBox
    	optionsVBox.getChildren().clear();
    	usernameLabel = tempUsernameLabel;
    	isOptions = false;
    	optionsVBox.getChildren().add(FXMLLoader.load(getClass().getResource("playerOptions.fxml")));
//    	System.out.println(tempUsernameLabel);
    	
//    	optionsVBox.getChildren().add(usernameLabel);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(650),
                ae ->{
                        FadeTransition fi = new FadeTransition(Duration.millis(650), options);
                        fi.setFromValue(0);
                        fi.setToValue(1);
                        fi.play();
                }
        ));
        timeline.play();
    }    

    //hover effect
    public void mouseEnter(){
        RollButton.setStyle(HOVERED_BUTTON_STYLE);
        RollButton.setOpacity(1);
    }
    public void mouseExit(){
        RollButton.setStyle(IDLE_BUTTON_STYLE);
        RollButton.setOpacity(0.7);
    }

    //get rezultati per me perdor per chat
    public int getFinalRezultati() {
        return finalRezultati;
    }
    
    public void actionPerformed( ActionEvent e ) {

		if( e.getSource() == btnSend ) {
			
			if( cc != null) {
				if(!message.getText().isEmpty()) {
					cc.send( username+"@@966253120@@" +message.getText());
					message.setText( "" );
					message.requestFocus();
				}
				
			}

		} else if( e.getSource() == connect ) {
			try {
				
				// cc = new ChatClient(new URI(uriField.getText()), area, ( Draft ) draft.getSelectedItem() );
				cc = new WebSocketClient( new URI( "ws://localhost:81" )) {

					@Override
					public void onMessage( String message ) {
						Chat.setStyle("-fx-font-alignment: right");
						String[] fullMessage = message.split("@@966253120@@",2);
						String userNamString = fullMessage[0];
						String messageString = fullMessage[1];
						Chat.appendText( "\n"+userNamString+": "+messageString+ "\n" );
						Chat.positionCaret(Chat.getLength());
					}

					@Override
					public void onOpen( ServerHandshake handshake ) {
						Chat.appendText( "\nYou are connected to ChatServer: " + getURI() + "\n" );
						Chat.positionCaret(Chat.getLength());
						
					}

					@Override
					public void onClose( int code, String reason, boolean remote ) {
						Chat.appendText( "\nYou have been disconnected from: " + getURI() + "; Code: " + code + " " + reason + "\n" );
					}

					@Override
					public void onError( Exception ex ) {
						Chat.appendText( "Exception occured ...\n" + ex + "\n" );
						ex.printStackTrace();	
						
					}

					
				};	
				cc.connect();
			} catch ( URISyntaxException ex ) {
				Chat.appendText( "ws://localhost:81" + " is not a valid WebSocket URI\n" );
			}
		
		}
	}
    
    public void logOut() throws IOException {
//    	usernameLabel = null;
//    	optionsVBox.getChildren().clear();
//    	usernameLabel = tempUsernameLabel;
    	isOptions = false;
    	firstTime = true;
    	Main.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
    }
    
    
    public static void setUsername(String user) {
    	username = user;
    }
    public static String getUsername() {
    	return username;
    }
   
    public void testing () {
//    	usernameLabel.textProperty().bind(username);
    }
	
    @FXML
	private void enterPressed() {
		Main.primaryStage.getScene().getFocusOwner().setOnKeyPressed(e->{
			if(e.getCode() == KeyCode.ENTER) {
				btnSend.fire();
			}
		
		});
    
    }
}
