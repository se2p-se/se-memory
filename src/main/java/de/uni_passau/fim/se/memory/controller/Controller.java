package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.GUI;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.Duration;


import java.io.IOException;

public class Controller {
    MainMenue mainMenue = new MainMenue();
    Game game = new Game();


    @FXML
    public void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
        labelSetter("WBAKCKE");

    }


    @FXML
    public void playAgainstTime(ActionEvent event) throws IOException {
        mainMenue.setGameModeTime(true);
        mainMenue.setGameModeBot(false);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void playAgainstBot(ActionEvent event) throws IOException {
        mainMenue.setGameModeBot(true);
        mainMenue.setGameModeTime(false);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void easyBoard(ActionEvent event) throws IOException {
        game.setGameBoardSize(3, 4);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void mediumBoard(ActionEvent event) throws IOException {
        game.setGameBoardSize(4, 4);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void difficultBoard(ActionEvent event) throws IOException {
        game.setGameBoardSize(5, 4);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GUI.switchScene(stage, "mainMenue.fxml");
    }

    @FXML
    public void startGameButton(ActionEvent event) throws IOException {
        if (mainMenue.getGameModeBot()) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            GUI.switchScene(stage, "gui.fxml");
        }
    }

    @FXML
    public void activateHelpButton() {
        mainMenue.setActivateHelp(!MainMenue.getActivateHelp());
        if(MainMenue.getActivateHelp()){
            label.setText("Help is now activated!");
        } else {
            label.setText("Help is now deactivated!");

        }
        makeFadeOut();
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


    public void makeFadeOut(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.setNode(label);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

    }

    @FXML
    private Label label;



    public void labelSetter(String text) {
        label.setText(text);
    }

}