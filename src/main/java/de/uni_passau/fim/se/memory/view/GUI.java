package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.SavingStats;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    static private Class ResourceDirectory = null;

    static public Scene switchScene(Stage stage, String newScene) throws IOException {
        Parent root = FXMLLoader.load(ResourceDirectory.getResource(newScene));
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.show();

        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ResourceDirectory = getClass();
        Parent root = FXMLLoader.load(ResourceDirectory.getResource("mainMenue.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("gui.css").toExternalForm());

        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();
    }


    public static void start_gui() {
        launch();
    }
}
