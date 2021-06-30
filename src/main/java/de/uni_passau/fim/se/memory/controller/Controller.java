package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    MainMenue mainMenue = new MainMenue();
    Game game = new Game();



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
}