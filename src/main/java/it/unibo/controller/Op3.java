package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.UUID;
import javafx.scene.control.Alert;

public class Op3 {
    
    @FXML
    private TextField Disponibilita;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private TextField Tipo;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation() {
        addNewEmployee(Disponibilita.getText(), Nome.getText(), Cognome.getText(), generateUniqueId(), Tipo.getText());
    }

    private String generateUniqueId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.length() > 30 ? uuid.substring(0, 30) : uuid;
    }

    public void addNewEmployee(String disponibilita, String nome, String cognome, String id, String tipo) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_EMPLOYEE)) {
            stmt.setString(1, disponibilita);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, id);
            stmt.setString(5, tipo);
            stmt.executeUpdate();
            System.out.println("Dipendente aggiunto con successo.");
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
