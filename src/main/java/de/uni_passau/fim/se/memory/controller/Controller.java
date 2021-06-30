package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    MainMenue mainMenue = new MainMenue();
    Game game = new Game();



    @FXML public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void playAgainstTime(ActionEvent event) throws IOException{
        mainMenue.setGameModeTime(true);
        mainMenue.setGameModeBot(false);
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void playAgainstBot(ActionEvent event) throws IOException{
        mainMenue.setGameModeBot(true);
        mainMenue.setGameModeTime(false);
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void easyBoard(ActionEvent event) throws IOException{
        game.setGameBoardSize(3,4);
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void mediumBoard(ActionEvent event) throws IOException{
        game.setGameBoardSize(4,4);
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void difficultBoard(ActionEvent event) throws IOException {
        game.setGameBoardSize(5,4);
        Parent root = FXMLLoader.load(getClass().getResource("/de/uni_passau/fim/se/memory/view/MainMenueTest.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
}