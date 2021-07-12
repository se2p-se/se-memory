package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenu;
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

/**
 * Main controller for fxml scenes and models
 */
public class Controller {
    private static MainMenu mainMenu = new MainMenu();
    private static Game game = new Game();
    private static boolean soundPlayed = false;
    private static long startTime;
    private static long endTime;

    /**
     * Contains file path constants
     */
    static final class CONSTANTS {
        public static final String CARDBACK = "de/uni_passau/fim/se/memory/view/images/CardBack.png";
        public static final String IMAGE_CARD = "de/uni_passau/fim/se/memory/view/images/Card";
        public static final String MAIN_MENU = "mainMenue.fxml";
        public static final String GAMEBOARD_54 = "gameBoard_5x4.fxml";
        public static final String SUBMENU_GAMEMODE = "Submenue_GameMode.fxml";
        public static final String SUBMENU_GAMEBOARDSIZE = "Submenue_GameBoardSize.fxml";
        public static final String SUBMENU_BOTDIFFICULTY = "Submenue_BotDifficulty.fxml";

    }

    /**
     * Initialize Controller and play sound if needed
     */
    public Controller() {
        if (!soundPlayed) {
            SoundPlayer.playSound("GameOST");
            soundPlayed = true;
        }

    }

    @FXML
    private GridPane gridPane0;

    List<ImageCharMapping> cardFront = new ArrayList<>();
    Image cardBack = new Image(CONSTANTS.CARDBACK);

    /**
     * Initialize controller
     *
     * 1. Load card fronts with Characters and add to cardFront
     * 2. Generate GUI-Cards
     * 3. Activate help on GUI-Cards if requested (see mainMenue.getActivateHelp)
     */
    @FXML public void initialize() {

        if (labelEasy != null) {
            labelEasy.setText("Record for boardsize easy: " + savingStats.statsReaderEasy()/1000 + " seconds");
            labelMedium1.setText("Record for boardsize medium: " + savingStats.statsReaderMedium()/1000 + " seconds");
            labelDifficult.setText("Record for boardsize difficult: "  + savingStats.statsReaderDifficult()/1000 + " seconds");
        }

        if (gridPane0 == null) {
            return;
        }

        // dynamically load card fronts and assign Characters
        for (int i = 1; i < 11; ++i) {
            Image img = new Image(CONSTANTS.IMAGE_CARD + ((i < 10) ? ("0" + i) : i) +".png");
            Character ch = (char)('A' + i - 1);

            ImageCharMapping chmp = new ImageCharMapping();
            chmp.ch = ch;
            chmp.img = img;

            cardFront.add(chmp);
        }

        createCards();

        if (mainMenu.getActivateHelp()) {

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

        if (mainMenu.getActivateHelp()) {

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
     * Switch to main menu and notify user of the change
     * @param event
     * @throws IOException
     */
    @FXML
    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, CONSTANTS.MAIN_MENU);
        makeFadeOut(label);
    }

    /**
     * Set GameMode to be against time notify user of the change
     * @param event
     */
    @FXML
    public void playAgainstTime(ActionEvent event) {
        mainMenu.setGameModeTime(true);
        mainMenu.setGameModeBot(false);
        labelGameMode.setText(OutputStreamGameModeTime.printAgainstTime());
        makeFadeOut(labelGameMode);

    }

    /**
     * Set GameMode to be against bot notify user of the change
     * @param event
     */
    @FXML
    public void playAgainstBot(ActionEvent event) {
        mainMenu.setGameModeBot(true);
        mainMenu.setGameModeTime(false);
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
        labelBoardSize.setText(OutputStreamMainMenu.printEasySize());
        makeFadeOut(labelBoardSize);

    }

    /**
     * Set game board size to (4,4) and notify user of the change
     * @param event
     */
    @FXML
    public void mediumBoard(ActionEvent event) {
        game.setGameBoardSize(4, 4);
        labelBoardSize.setText(OutputStreamMainMenu.printMediumSize());
        makeFadeOut(labelBoardSize);
    }

    /**
     * Set game board size to (5,4) and notify user of the change
     * @param event
     */
    @FXML
    public void difficultBoard(ActionEvent event) {
        game.setGameBoardSize(5, 4);
        labelBoardSize.setText(OutputStreamMainMenu.printDifficultSize());
        makeFadeOut(labelBoardSize);
    }

    /**
     * Set bot difficulty to 1 and notify user of the change
     * @param event
     */
    @FXML
    public void easyBot(ActionEvent event){
        MainMenu.setBotDifficulty(1);
        labelBotDifficulty.setText(OutputStreamMainMenu.printEasyBot());
        makeFadeOut(labelBotDifficulty);

    }

    /**
     * Set bot difficulty to 2 and notify user of the change
     * @param event
     */
    @FXML
    public void mediumBot(ActionEvent event) {
        MainMenu.setBotDifficulty(2);
        labelBotDifficulty.setText(OutputStreamMainMenu.printMediumBot());
        makeFadeOut(labelBotDifficulty);
    }

    /**
     * Set bot difficulty to 3 and notify user of the change
     * @param event
     */
    @FXML
    public void difficultBot(ActionEvent event) {
        MainMenu.setBotDifficulty(3);
        labelBotDifficulty.setText(OutputStreamMainMenu.printDifficultBot());
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
        GUI.switchScene(stage, CONSTANTS.GAMEBOARD_54);
        startTime = System.currentTimeMillis();
    }

    /**
     * Switch to main menu
     * @param event
     * @throws IOException
     */
    @FXML
    public void backToMenue(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, CONSTANTS.MAIN_MENU);
    }

    /**
     * Invert if user should be helped during the game and notify user of the change
     */
    @FXML
    public void activateHelpButton() {
        mainMenu.setActivateHelp(!MainMenu.getActivateHelp());
        if(MainMenu.getActivateHelp()){
            button.setText(OutputStreamMainMenu.showHelpActivated());
        } else {
            button.setText(OutputStreamMainMenu.showHelpDectivated());

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
        GUI.switchScene(stage, CONSTANTS.SUBMENU_GAMEMODE);

    }

    /**
     * Switch to game board submenu
     * @param event
     * @throws IOException
     */
    @FXML
    public void selectGameBoardSizeButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, CONSTANTS.SUBMENU_GAMEBOARDSIZE);
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
        GUI.switchScene(stage, CONSTANTS.SUBMENU_BOTDIFFICULTY);
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


    public void switchToGameBoard_5x4(ActionEvent event) throws IOException {

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, CONSTANTS.GAMEBOARD_54);
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
            handleCardsAvailable(visibleCards);
        }

        if (game.isGameFinished()) {
            handleGameFinished(click);
        }


        updateCards();
    }

    /**
     * Handles click on a card if user choose second card
     * User is notified if he choose successful a pair
     * @param visibleCards
     */
    private void handleCardsAvailable(ArrayList<Card> visibleCards) {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( "Memory" );
        alert.setHeaderText( "Pair of cards" );
        if (visibleCards.get(0).compareWith(visibleCards.get(1))) {
            visibleCards.get(0).setValue(null);
            visibleCards.get(1).setValue(null);
            playSound("Pair");
        } else {
            playSound("NoPair");
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

    /**
     * Handle if the game is finished
     * Show information and redirect to main menu
     * @param click
     */
    private void handleGameFinished(MouseEvent click) {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( "Memory" );
        alert.setHeaderText( "Game is finished!" );
        alert.setContentText("You won!");
        alert.showAndWait();

            Stage stage =
                    (Stage) ((Node) click.getSource()).getScene().getWindow();
            try {
                GUI.switchScene(stage, CONSTANTS.MAIN_MENU);
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

    SavingStats savingStats = SavingStats.getSavingStats();

    public void clickHighScore(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "Submenu_Records.fxml");

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