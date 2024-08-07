package it.unibo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;


import java.io.IOException;

public class MainViewController {

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleOp1() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op1.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inserisci i parametri");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Errore durante il caricamento dell'interfaccia!");
        }
    }

    @FXML
    private void handleOp2() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op2.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Inserisci i parametri");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Errore durante il caricamento dell'interfaccia!");
        }
    }

    @FXML
    private void handleOp3() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op3.fxml"));

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

    @FXML
    private void handleOp4() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op4.fxml"));

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

    @FXML
    private void handleOp5() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op5.fxml"));

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

    @FXML
    private void handleOp6() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op6.fxml"));

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

    @FXML
    private void handleOp7() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op7.fxml"));

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

    @FXML
    private void handleOp8() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op8.fxml"));

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

    @FXML
    private void handleOp9() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op9.fxml"));

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

    @FXML
    private void handleOp10() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op10.fxml"));

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
    @FXML
    private void handleOp11() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op11.fxml"));

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
    @FXML
    private void handleOp12() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op12.fxml"));

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
    @FXML
    private void handleOp13() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op13.fxml"));

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
    @FXML
    private void handleOp14() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op14.fxml"));

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
    @FXML
    private void handleOp15() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op15.fxml"));

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
    @FXML
    private void handleOp16() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op16.fxml"));

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
    @FXML
    private void handleOp17() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op17.fxml"));

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
    @FXML
    private void handleOp18() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op18.fxml"));

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
    @FXML
    private void handleOp19() {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("it.unibo.resources.OperationExecutor.fxml"));
            //VBox root = loader.load();
            VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("Op19.fxml"));

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

    @FXML
    public void getTenBestDrinks() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(Queries.TEN_BEST_DRINKS)) {
            ResultSet rs = stmt.executeQuery();
            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                String nomeBevanda = rs.getString("Nome");
                int numeroRichieste = rs.getInt("NumeroRichieste");
                result.append("Bevanda: ").append(nomeBevanda).append(", Numero Richieste: ").append(numeroRichieste).append("\n");
            }
            showAlert("Le dieci migliori bevande", result.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Errore", "Si è verificato un errore durante l'esecuzione della query.");
        }
    }

    @FXML
    public void getBestTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(Queries.BEST_TABLE)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomeTavolo = rs.getString("Nome");
                int numeroEventi = rs.getInt("NumeroEventi");
                String result = "Tavolo con più eventi: " + nomeTavolo + ", Numero eventi: " + numeroEventi;
                showAlert("Il miglior tavolo", result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Errore", "Si è verificato un errore durante l'esecuzione della query.");
        }
    }

    @FXML
    public void getBestPR() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(Queries.BEST_PR)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomePR = rs.getString("Nome");
                String cognomePR = rs.getString("Cognome");
                int incassoTotale = rs.getInt("IncassoTotale");
                String result = "Miglior PR: " + nomePR + " " + cognomePR + ", Incasso totale: " + incassoTotale;
                showAlert("Il miglior PR", result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Errore", "Si è verificato un errore durante l'esecuzione della query.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
