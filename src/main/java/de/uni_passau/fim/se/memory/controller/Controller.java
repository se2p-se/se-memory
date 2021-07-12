package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.model.SavingStats;
import de.uni_passau.fim.se.memory.view.*;
import de.uni_passau.fim.se.memory.view.GUI;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeBot;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import java.util.List;

class ImageCharMapping {
    Character ch;
    Image img;
}

public class Controller {
    private static MainMenue mainMenue = new MainMenue();
    private static Game game = new Game();
    private static boolean soundPlayed = false;
    private static long startTime;
    private static long endTime;

    public Controller() {
        if (!soundPlayed) {
            SoundPlayer.playSound("GameOST");
            soundPlayed = true;
        }

    }

    @FXML
    private GridPane gridPane0;

    List<ImageCharMapping> cardFront = new ArrayList<>();
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

        createCards();

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

    /**
     * Generate GUI-Cards
     */
    private void createCards() {
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

    /**
     * Set GameMode to be against bot notify user of the change
     * @param event
     */
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
        labelBoardSize.setText(OutputStreamMainMenu.printEasySize());
        makeFadeOut(labelBoardSize);

    }

    @FXML
    public void mediumBoard(ActionEvent event) {
        game.setGameBoardSize(4, 4);
        labelBoardSize.setText(OutputStreamMainMenu.printMediumSize());
        makeFadeOut(labelBoardSize);
    }

    @FXML
    public void difficultBoard(ActionEvent event) {
        game.setGameBoardSize(5, 4);
        labelBoardSize.setText(OutputStreamMainMenu.printDifficultSize());
        makeFadeOut(labelBoardSize);
    }

    @FXML
    public void easyBot(ActionEvent event){
        MainMenue.setBotDifficulty(1);
        labelBotDifficulty.setText(OutputStreamMainMenu.printEasyBot());
        makeFadeOut(labelBotDifficulty);

    }

    @FXML
    public void mediumBot(ActionEvent event) {
        MainMenue.setBotDifficulty(2);
        labelBotDifficulty.setText(OutputStreamMainMenu.printMediumBot());
        makeFadeOut(labelBotDifficulty);
    }

    @FXML
    public void difficultBot(ActionEvent event) {
        MainMenue.setBotDifficulty(3);
        labelBotDifficulty.setText(OutputStreamMainMenu.printDifficultBot());
        makeFadeOut(labelBotDifficulty);
    }

    @FXML
    public void startGameButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "gameBoard_5x4.fxml");
        startTime = System.currentTimeMillis();
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
            button.setText(OutputStreamMainMenu.showHelpActivated());
        } else {
            button.setText(OutputStreamMainMenu.showHelpDectivated());

        }

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

    /**
     * Adds transition effect to label, when a setting has been changed
     * @param label, trasnsition effect to be appended to
     */
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



    public void labelSetter(String text) {
        label.setText(text);
    }


    /**
     * Sets text on label
     * @param text
     */
    public void labelSetter(String text) {
        label.setText(text);
    }


    public void switchToGameBoard_5x4(ActionEvent event) throws IOException {

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "gameBoard_5x4.fxml");
    }

    /**
     * Handles the click on a card during the game
     *
     * If there are still cards left an information notification is issued
     * If there are no cards left a win notification is issued
     *
     * After each click the visible cards get updated
     *
     * A sound is played on a click
     * @param click
     */
    public void OnClickCard(MouseEvent click){

        SoundPlayer.playSound("OnClickCard");

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
                SoundPlayer.playSound("Pair");
                alert.setContentText("You found a pair!");
            } else {
                SoundPlayer.playSound("NoPair");
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
            endTime = System.currentTimeMillis();
            String endOfGameOutput;
            if (game.getGameBoardSize()[0] == 5) {
                if (endTime - startTime < savingStats.statsReaderDifficult()) {
                    endOfGameOutput = OutputStreamGameModeTime.printNewRecord();
                    savingStats.statsWriterDifficult(endTime - startTime); //saving new record
                }
                else {
                    endOfGameOutput = OutputStreamGameModeTime.printRecordNotBroken();
                }
            } else if (game.getGameBoardSize()[0] == 4) {
                if (endTime - startTime < savingStats.statsReaderMedium()) {
                    endOfGameOutput = OutputStreamGameModeTime.printNewRecord();
                    savingStats.statsWriterMedium(endTime - startTime); //saving new record
                }
                else {
                    endOfGameOutput = OutputStreamGameModeTime.printRecordNotBroken();
                }
            } else if (game.getGameBoardSize()[0] == 3) {
                if (endTime - startTime < savingStats.statsReaderEasy()) {
                    endOfGameOutput = OutputStreamGameModeTime.printNewRecord();
                    savingStats.statsWriterEasy(endTime - startTime); //saving new record
                }
                else {
                    endOfGameOutput = OutputStreamGameModeTime.printRecordNotBroken();
                }
            }
            else {
                endOfGameOutput = "";
            }

            Alert alert = new Alert( Alert.AlertType.INFORMATION );
            alert.setTitle( "Memory" );
            alert.setHeaderText( "Game is finished!" );
            alert.setContentText("You won! " + endOfGameOutput);
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

    /**
     * Close the application
     * @param event
     */
    public void endMenueButton(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    SavingStats savingStats = SavingStats.getSavingStats();

    public void clickHighScore(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenu_Records.fxml");
        labelEasy.setText(savingStats.statsReaderEasy()/1000 + " seconds");
        labelMedium1.setText(savingStats.statsReaderMedium()/1000 + " seconds");
        labelDifficult.setText(savingStats.statsReaderDifficult()/1000 + " seconds");
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

    @FXML
    private Label labelEasy;

    @FXML
    private Label labelMedium1;

    @FXML
    private Label labelDifficult;
}