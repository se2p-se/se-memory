package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

class ImageCharMapping {
    Character ch;
    Image img;
}

public class Controller {
    private Game game;

    private ImageView[] imageViewCards;
    private boolean initialize;
    private MainMenue mainMenue;

    @FXML
    private AnchorPane anchorPane0;
    @FXML
    private GridPane gridPane0;

    @FXML
    public ImageView Card_00;
    public ImageView Card_01;
    public ImageView Card_02;
    public ImageView Card_03;
    public ImageView Card_10;
    public ImageView Card_11;
    public ImageView Card_12;
    public ImageView Card_13;
    public ImageView Card_20;
    public ImageView Card_21;
    public ImageView Card_22;
    public ImageView Card_23;
    public ImageView Card_30;
    public ImageView Card_31;
    public ImageView Card_32;
    public ImageView Card_33;
    public ImageView Card_40;
    public ImageView Card_41;
    public ImageView Card_42;
    public ImageView Card_43;

    ArrayList<ImageCharMapping> cardFront = new ArrayList<>();
    Image cardBack = new Image("de/uni_passau/fim/se/memory/view/images/CardBack.png");

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
            dynCard.setOnMouseClicked(this::showImage);

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
        initialize = true;
        mainMenue = new MainMenue();
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

    public void showImage(MouseEvent click){

        ImageView view = (ImageView)click.getTarget();

        Card selectedCard = game.selectCard(GridPane.getRowIndex(view) + 1,
                GridPane.getColumnIndex(view) + 1);

        selectedCard.flipCard();

        view.setImage(selectedCard.getIsHidden() ? cardBack :
                cardFront.get(selectedCard.getValue() - 'A').img);
    }
}
