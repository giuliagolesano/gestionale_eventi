package it.unibo.db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestione Eventi");
        primaryStage.show();
    }

    public void start(String[] args) {
        launch(args);
    }
}
