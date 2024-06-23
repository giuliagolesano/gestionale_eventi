package it.unibo.db;

import it.unibo.controller.DatabaseController;
import it.unibo.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        VBox root = loader.load();

        MainViewController mainController = loader.getController();
        DatabaseController dbController = new DatabaseController();

        mainController.setDbController(dbController);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestione Eventi");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
