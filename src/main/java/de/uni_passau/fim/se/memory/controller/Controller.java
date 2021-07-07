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
import java.util.List;

/**
 * Main controller for fxml scenes and models
 */
public class Controller {
    private static MainMenue mainMenue = new MainMenue();
    private static Game game = new Game();
    private static SoundPlayer soundPlayer = new SoundPlayer();

    /**
     * Initialize Controller and play sound if needed
     */
    public Controller() {
        soundPlayer.playSound("GameOST");
    }

    @FXML
    private GridPane gridPane0;

    List<ImageCharMapping> cardFront = new ArrayList<>();
    Image cardBack = new Image("de/uni_passau/fim/se/memory/view/images/CardBack.png");

    /**
     * Initialize controller
     *
     * 1. Load card fronts with Characters and add to cardFront
     * 2. Generate GUI-Cards
     * 3. Activate help on GUI-Cards if requested (see mainMenue.getActivateHelp)
     */
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

    /**
     * Switch to main menu and notify user of the change
     * @param event
     * @throws IOException
     */
    @FXML
    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
        makeFadeOut(label);
    }

    /**
     * Set GameMode to be against time notify user of the change
     * @param event
     */
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

    /**
     * Set game board size to (3,4) and notify user of the change
     * @param event
     */
    @FXML
    public void easyBoard(ActionEvent event){
        game.setGameBoardSize(3, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printEasySize());
        makeFadeOut(labelBoardSize);

    }

    /**
     * Set game board size to (4,4) and notify user of the change
     * @param event
     */
    @FXML
    public void mediumBoard(ActionEvent event) {
        game.setGameBoardSize(4, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printMediumSize());
        makeFadeOut(labelBoardSize);
    }

    /**
     * Set game board size to (5,4) and notify user of the change
     * @param event
     */
    @FXML
    public void difficultBoard(ActionEvent event) {
        game.setGameBoardSize(5, 4);
        labelBoardSize.setText(OutputStreamMainMenue.printDifficultSize());
        makeFadeOut(labelBoardSize);
    }

    /**
     * Set bot difficulty to 1 and notify user of the change
     * @param event
     */
    @FXML
    public void easyBot(ActionEvent event){
        MainMenue.setBotDifficulty(1);
        labelBotDifficulty.setText(OutputStreamMainMenue.printEasyBot());
        makeFadeOut(labelBotDifficulty);

    }

    /**
     * Set bot difficulty to 2 and notify user of the change
     * @param event
     */
    @FXML
    public void mediumBot(ActionEvent event) {
        MainMenue.setBotDifficulty(2);
        labelBotDifficulty.setText(OutputStreamMainMenue.printMediumBot());
        makeFadeOut(labelBotDifficulty);
    }

    /**
     * Set bot difficulty to 3 and notify user of the change
     * @param event
     */
    @FXML
    public void difficultBot(ActionEvent event) {
        MainMenue.setBotDifficulty(3);
        labelBotDifficulty.setText(OutputStreamMainMenue.printDifficultBot());
        makeFadeOut(labelBotDifficulty);
    }

    /**
     * Starts the actual game round
     * @param event
     * @throws IOException
     */
    @FXML
    public void startGameButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "gameBoard_5x4.fxml");
    }

    /**
     * Switch to main menu
     * @param event
     * @throws IOException
     */
    @FXML
    public void backToMenue(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    /**
     * Invert if user should be helped during the game and notify user of the change
     */
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

    /**
     * Switch to game mode submenu
     * @param event
     * @throws IOException
     */
    @FXML
    public void selectGameModeButton(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenue_GameMode.fxml");

    }

    /**
     * Switch to game board submenu
     * @param event
     * @throws IOException
     */
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

    /**
     * Switch to game bit difficulty submenu
     * @param event
     * @throws IOException
     */
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


    /**
     * Sets text on label
     * @param text
     */
    public void labelSetter(String text) {
        label.setText(text);
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

        soundPlayer.playSound("OnClickCard");

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
                soundPlayer.playSound("Pair");
                alert.setContentText("You found a pair!");
            } else {
                soundPlayer.playSound("NoPair");
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

    /**
     * Update card view to user
     */
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
}