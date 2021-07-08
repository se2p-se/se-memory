package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.Main;
import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.GUI;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeBot;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenue;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

class ImageCharMapping {
    Character ch;
    Image img;
}

public class Controller {
    private static MainMenue mainMenue = new MainMenue();
    private static Game game = new Game();
    private static boolean soundPlayed = false;

    public Controller() {
        if (!soundPlayed) {
            playSound("GameOST");
            soundPlayed = true;
        }

    }

    @FXML
    private GridPane gridPane0;

    ArrayList<ImageCharMapping> cardFront = new ArrayList<>();
    Image cardBack = new Image("de/uni_passau/fim/se/memory/view/images/CardBack.png");

    @FXML public void initialize() {

        if (gridPane0 == null) {
            return;
        }

        // dynamically load card fronts and assign Characters
        for (int i = 1; i < 11; ++i) {
            Image img = new Image("de/uni_passau/fim/se/memory/view/images"
                    + "/Card" + ((i < 10) ? ("0" + i) : i) +".png");
            Character ch = (char)('A' + i - 1);

            ImageCharMapping chmp = new ImageCharMapping();
            chmp.ch = ch;
            chmp.img = img;

            cardFront.add(chmp);
        }

        // create cards
        int x = 0, y = 0;
        for (Card c : game.getCards()) {

            ImageView dynCard = new ImageView();
            dynCard.setImage(cardBack);
            GridPane.setMargin(dynCard, new Insets(5));
            dynCard.setFitWidth(128);
            dynCard.setPreserveRatio(true);
            dynCard.setOnMouseClicked(this::OnClickCard);

            gridPane0.add(dynCard, x, y);

            x++;
            if (x >= game.getGameBoardSize()[0]) { // max columns
                x = 0;
                y++;
            }
        }

        if (mainMenue.getActivateHelp()) {

            for (Card c : game.getCards()) c.flipCard();
            updateCards();

            Timeline idlestage =
                    new Timeline( new KeyFrame( Duration.millis(2000),
                            event -> {
                                for (Card c : game.getCards()) c.flipCard();
                                updateCards();
                            }) );
            idlestage.setCycleCount( 1 );
            idlestage.play();
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
        makeFadeOut(label);
    }


    @FXML
    public void playAgainstTime(ActionEvent event) {
        mainMenue.setGameModeTime(true);
        mainMenue.setGameModeBot(false);
        labelGameMode.setText(OutputStreamGameModeTime.printAgainstTime());
        makeFadeOut(labelGameMode);

    }

    @FXML
    public void playAgainstBot(ActionEvent event) {
        mainMenue.setGameModeBot(true);
        mainMenue.setGameModeTime(false);
        labelGameMode.setText(OutputStreamGameModeBot.printAgainstBot());
        makeFadeOut(labelGameMode);
    }

    @FXML
    public void easyBoard(ActionEvent event){
        game.setGameBoardSize(3, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printEasySize());
        makeFadeOut(labelBoardSize);

    }

    @FXML
    public void mediumBoard(ActionEvent event) {
        game.setGameBoardSize(4, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printMediumSize());
        makeFadeOut(labelBoardSize);
    }

    @FXML
    public void difficultBoard(ActionEvent event) {
        game.setGameBoardSize(5, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printDifficultSize());
        makeFadeOut(labelBoardSize);
    }

    @FXML
    public void easyBot(ActionEvent event){
        MainMenue.setBotDifficulty(1);
        labelBotDifficulty.setText(OutputStreamMainMenue.printEasyBot());
        makeFadeOut(labelBotDifficulty);

    }

    @FXML
    public void mediumBot(ActionEvent event) {
        MainMenue.setBotDifficulty(2);
        labelBotDifficulty.setText(OutputStreamMainMenue.printMediumBot());
        makeFadeOut(labelBotDifficulty);
    }

    @FXML
    public void difficultBot(ActionEvent event) {
        MainMenue.setBotDifficulty(3);
        labelBotDifficulty.setText(OutputStreamMainMenue.printDifficultBot());
        makeFadeOut(labelBotDifficulty);
    }

    @FXML
    public void startGameButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "gameBoard_5x4.fxml");
    }

    @FXML
    public void backToMenue(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void activateHelpButton() {
        mainMenue.setActivateHelp(!MainMenue.getActivateHelp());
        if(MainMenue.getActivateHelp()){
            button.setText(OutputStreamMainMenue.showHelpActivated());
        } else {
            button.setText(OutputStreamMainMenue.showHelpDectivated());

        }
        makeFadeOut(label);

    }

    @FXML
    public void selectGameModeButton(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenue_GameMode.fxml");

    }

    @FXML
    public void selectGameBoardSizeButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenue_GameBoardSize.fxml");
    }


    public void makeFadeOut(Node label){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.setNode(label);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    @FXML
    public void selectBotDifficulty(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenue_BotDifficulty.fxml");
    }

    @FXML
    private Label label;

    @FXML
    private Label labelBoardSize;

    @FXML
    private Label labelGameMode;

    @FXML
    private Label labelBotDifficulty;

    @FXML
    private Button button;



    public void labelSetter(String text) {
        label.setText(text);
    }


    public void switchToGameBoard_5x4(ActionEvent event) throws IOException {

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "gameBoard_5x4.fxml");
    }

    public void OnClickCard(MouseEvent click){

        playSound("OnClickCard");

        ImageView view = (ImageView)click.getTarget();

        Card selectedCard = game.selectCard(GridPane.getRowIndex(view) + 1,
                GridPane.getColumnIndex(view) + 1);

        ArrayList<Card> visibleCards = new ArrayList<>();
        for (Card c : game.getCards()) {
            if (!c.getIsHidden() && c.getValue() != null)
                visibleCards.add(c);
        }

        if (visibleCards.size() >= 2) return;

        if (selectedCard.getIsHidden())
            selectedCard.flipCard();

        updateCards();

        visibleCards.clear();
        for (Card c : game.getCards()) {
            if (!c.getIsHidden() && c.getValue() != null)
                visibleCards.add(c);
        }

        if (visibleCards.size() >= 2) {
            Alert alert = new Alert( Alert.AlertType.INFORMATION );
            alert.setTitle( "Memory" );
            alert.setHeaderText( "Pair of cards" );
            if (visibleCards.get(0).compareWith(visibleCards.get(1))) {
                visibleCards.get(0).setValue(null);
                visibleCards.get(1).setValue(null);
                playSound("Pair");
                alert.setContentText("You found a pair!");
            } else {
                playSound("NoPair");
                alert.setContentText("You found no pair. :-(");
            }

            Timeline idlestage =
                    new Timeline( new KeyFrame( Duration.millis(2000),
                            event -> {
                                alert.setResult(ButtonType.OK);
                                alert.hide();
                                visibleCards.get(0).flipCard();
                                visibleCards.get(1).flipCard();
                                updateCards();
                            }) );
            idlestage.setCycleCount( 1 );
            idlestage.play();
            alert.show();
        }

        if (game.isGameFinished()) {
            Alert alert = new Alert( Alert.AlertType.INFORMATION );
            alert.setTitle( "Memory" );
            alert.setHeaderText( "Game is finished!" );
            alert.setContentText("You won!");
            alert.showAndWait();

            Stage stage =
                    (Stage) ((Node) click.getSource()).getScene().getWindow();
            try {
                GUI.switchScene(stage, "mainMenue.fxml");
            } catch (IOException e) {  }
        }


        updateCards();
    }

    private void updateCards() {
        for (var c : gridPane0.getChildren()) {
            ImageView view = (ImageView)c;

            Card selectedCard = game.selectCard(GridPane.getRowIndex(view) + 1,
                    GridPane.getColumnIndex(view) + 1);

            Character cardVal = selectedCard.getValue();

            if (cardVal == null) {
                view.setImage(null);
                continue;
            }

            view.setImage(selectedCard.getIsHidden() ? cardBack :
                    cardFront.get(cardVal - 'A').img);
        }
    }

    public static void playSound(String str) {
        URL url;

        try {
            url = switch (str) {
                case "Pair" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/Pair.wav");
                case "NoPair" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/NoPair.wav");
                case "GameOST" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/GameOST.wav");
                default -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/Click.wav");
            };

            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = volume.getMaximum() - volume.getMinimum();
            float gain = (range * 0.4f) + volume.getMinimum();
            volume.setValue(gain);
            if (str.equals("GameOST")) {
                clip.loop(999);
            } else {
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void endMenueButton(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}