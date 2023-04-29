package fr.thom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javafx.scene.image.Image;

import java.util.Objects;

public final class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getClassLoader().getResource("frame.fxml")));
        primaryStage.setTitle("BlindScape Launcher");
        primaryStage.setScene(new Scene(root, 500, 500));
        Image icon = new Image(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("textures/box.png")));
        primaryStage.getIcons().add(icon);
        primaryStage.show();

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }
}