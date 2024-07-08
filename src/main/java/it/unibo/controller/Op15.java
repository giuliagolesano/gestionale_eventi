package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;

public class Op15 {
    
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private DatePicker Data_Comportamento_Illecito;
    @FXML
    private TextField Descrizione_Comportamento_Illecito;
    @FXML
    private TextField Id;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setBlockedClient(Nome.getText(), Cognome.getText(), Date.valueOf(Data_Comportamento_Illecito.getValue()), Descrizione_Comportamento_Illecito.getText(), Id.getText());
    }

    public void setBlockedClient(String Nome, String Cognome, java.sql.Date Data_Comportamento_Illecito, String Descrizione_Comportamento_Illecito, String Id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_BLOCKED_CLIENT)) {
            stmt.setString(1, Nome);
            stmt.setString(2, Cognome);
            stmt.setDate(3, Data_Comportamento_Illecito);
            stmt.setString(4, Descrizione_Comportamento_Illecito);
            stmt.setString(5, Id);
            stmt.executeUpdate();
       showConfirmation("Dati inseriti correttamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            showError("Operation failed: " + e.getMessage());
        }
    }

    private void showConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
