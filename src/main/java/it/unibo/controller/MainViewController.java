package it.unibo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleOpenOperationExecutor() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            VBox root = loader.load();

            OperationExecutorController controller = loader.getController();

            DatabaseController dbController = new DatabaseController();

            controller.setDbController(dbController);

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Esegui Operazioni");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Errore durante il caricamento dell'interfaccia!");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
