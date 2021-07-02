package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.GUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

class ImageCharMapping {
    Character ch;
    Image img;
}

public class Controller {
    private Game game;
    private MainMenue mainMenue;

    @FXML
    private GridPane gridPane0;

    ArrayList<ImageCharMapping> cardFront = new ArrayList<>();
    Image cardBack = new Image("de/uni_passau/fim/se/memory/view/images/CardBack.png");
    ArrayList<ImageView> imageViews = new ArrayList<>();

    @FXML public void initialize() {

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
            if (x >= 5) { // max columns
                x = 0;
                y++;
            }
        }
    }

    public Controller() {
        game = new Game();
        mainMenue = new MainMenue();
        playSound("GameOST");
    }

    @FXML public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }

    @FXML public void playAgainstTime(ActionEvent event) throws IOException{
        mainMenue.setGameModeTime(true);
        mainMenue.setGameModeBot(false);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }

    @FXML public void playAgainstBot(ActionEvent event) throws IOException{
        mainMenue.setGameModeBot(true);
        mainMenue.setGameModeTime(false);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }

    @FXML public void easyBoard(ActionEvent event) throws IOException{
        game.setGameBoardSize(3,4);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }

    @FXML public void mediumBoard(ActionEvent event) throws IOException{
        game.setGameBoardSize(4,4);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }

    @FXML public void difficultBoard(ActionEvent event) throws IOException {
        game.setGameBoardSize(5,4);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "MainMenueTest.fxml");
    }


    public void switchToGameBoard_5x4(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/gameBoard_5x4.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene (root);
        stage.setScene(scene);

        scene.getStylesheets().add(getClass().getResource("/de/uni_passau/fim/se/memory/view/gameBoard.css").toExternalForm());

        stage.show();
    }

    public void OnClickCard(MouseEvent click){

        playSound("OnClickCard");

        ImageView view = (ImageView)click.getTarget();

        Card selectedCard = game.selectCard(GridPane.getRowIndex(view) + 1,
                GridPane.getColumnIndex(view) + 1);

        if (selectedCard.getIsHidden())
            selectedCard.flipCard();

        updateCards();

        ArrayList<Card> visibleCards = new ArrayList<>();

        for (Card c : game.getCards()) {
            if (!c.getIsHidden() && c.getValue() != null)
                visibleCards.add(c);
        }

        if (visibleCards.size() == 2) {
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
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
