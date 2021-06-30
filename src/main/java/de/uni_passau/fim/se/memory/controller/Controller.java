package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends InputStreamPlayer implements Initializable {

    private Stage stage;
    private Scene scene;
    private ImageView[] imageViewCards;
    private boolean initialize;

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

    Image imageCard01 = new Image("de/uni_passau/fim/se/memory/view/images/Card01.png");
    Image imageCard02 = new Image("de/uni_passau/fim/se/memory/view/images/Card02.png");
    Image imageCard03 = new Image("de/uni_passau/fim/se/memory/view/images/Card03.png");
    Image imageCard04 = new Image("de/uni_passau/fim/se/memory/view/images/Card04.png");
    Image imageCard05 = new Image("de/uni_passau/fim/se/memory/view/images/Card05.png");
    Image imageCard06 = new Image("de/uni_passau/fim/se/memory/view/images/Card06.png");
    Image imageCard07 = new Image("de/uni_passau/fim/se/memory/view/images/Card07.png");
    Image imageCard08 = new Image("de/uni_passau/fim/se/memory/view/images/Card08.png");
    Image imageCard09 = new Image("de/uni_passau/fim/se/memory/view/images/Card09.png");
    Image imageCard10 = new Image("de/uni_passau/fim/se/memory/view/images/Card10.png");
    Image cardBack = new Image("de/uni_passau/fim/se/memory/view/images/CardBack.png");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        imageViewCards = new ImageView[]{
                Card_00, Card_01, Card_02, Card_03,
                Card_10, Card_11, Card_12, Card_13,
                Card_20, Card_21, Card_22, Card_23,
                Card_30, Card_31, Card_32, Card_33,
                Card_40, Card_41, Card_42, Card_43};

        for (int i = 0; i < game.getCards().size(); i++) {
            imageViewCards[i] = new ImageView();
            imageViewCards[i].setId(game.getCards().get(i).getValue().toString());
            imageViewCards[i].setImage(cardBack);
        }
    }

    public Controller() {
        game = new Game();
        initialize = true;
    }

    @Override
    public Game getGame() {
        return game;
    }


    public void switchToGameBoard_5x4(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/gameBoard_5x4.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);

        scene.getStylesheets().add(getClass().getResource("/de/uni_passau/fim/se/memory/view/gameBoard.css").toExternalForm());

        stage.show();
    }

    public void showImage(MouseEvent click){

        if (initialize) {
            initializeCardIDs(getGame());
            initialize = false;
        }

        ImageView view = (ImageView)click.getTarget();

        System.out.println("This is view object: " + view);
        System.out.println("This is imageViewCards[0] object: " + imageViewCards[0]);

        System.out.println("This is view id: " + view.getId());
        System.out.println("This is imageViewCards[0] id: " + imageViewCards[0].getId());

        for (ImageView imageViewCard : imageViewCards) {
            if (view.getId().equals(imageViewCard.getId())) {
                switch (imageViewCard.getId()) {
                    case "A" -> view.setImage(imageCard01);
                    case "B" -> view.setImage(imageCard02);
                    case "C" -> view.setImage(imageCard03);
                    case "D" -> view.setImage(imageCard04);
                    case "E" -> view.setImage(imageCard05);
                    case "F" -> view.setImage(imageCard06);
                    case "G" -> view.setImage(imageCard07);
                    case "H" -> view.setImage(imageCard08);
                    case "I" -> view.setImage(imageCard09);
                    case "J" -> view.setImage(imageCard10);
                }
            }
        }
    }

    public void initializeCardIDs(Game game) {
        Card_00.setId(game.getCards().get(0).getValue().toString());
        Card_01.setId(game.getCards().get(1).getValue().toString());
        Card_02.setId(game.getCards().get(2).getValue().toString());
        Card_03.setId(game.getCards().get(3).getValue().toString());
        Card_10.setId(game.getCards().get(4).getValue().toString());
        Card_11.setId(game.getCards().get(5).getValue().toString());
        Card_12.setId(game.getCards().get(6).getValue().toString());
        Card_13.setId(game.getCards().get(7).getValue().toString());
        Card_20.setId(game.getCards().get(8).getValue().toString());
        Card_21.setId(game.getCards().get(9).getValue().toString());
        Card_22.setId(game.getCards().get(10).getValue().toString());
        Card_23.setId(game.getCards().get(11).getValue().toString());
        Card_30.setId(game.getCards().get(12).getValue().toString());
        Card_31.setId(game.getCards().get(13).getValue().toString());
        Card_32.setId(game.getCards().get(14).getValue().toString());
        Card_33.setId(game.getCards().get(15).getValue().toString());
        Card_40.setId(game.getCards().get(16).getValue().toString());
        Card_41.setId(game.getCards().get(17).getValue().toString());
        Card_42.setId(game.getCards().get(18).getValue().toString());
        Card_43.setId(game.getCards().get(19).getValue().toString());
    }
}