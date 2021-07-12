package de.uni_passau.fim.se.memory.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GUI extends Application {

    static private Class ResourceDirectory = null;

    /**
     * Method to switch scenes
     *
     * @param stage
     * @param newScene
     * @return
     * @throws IOException
     */
    static public Scene switchScene(Stage stage, String newScene) throws IOException {
        Parent root = FXMLLoader.load(ResourceDirectory.getResource(newScene));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        return scene;
    }

    /**
     * Method is starting GUI
     */
    public static void start_gui() {
        launch();
    }

    /**
     * Method to start first scene in GUI
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        ResourceDirectory = getClass();
        Parent root = FXMLLoader.load(ResourceDirectory.getResource("mainMenu.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("gui.css").toExternalForm());

        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();
    }
}
