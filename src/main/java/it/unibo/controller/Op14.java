package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Op14 {
    
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private TextField Disponibilita;
    @FXML
    private TextField Tipo;
    @FXML
    private TextField idDipendente;
 
    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setEmployee(Nome.getText(), Cognome.getText(), Disponibilita.getText(), Tipo.getText(), idDipendente.getText());
    }

    public void setEmployee(String nome, String cognome, String disponibilita, String tipo, String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_EMPLOYEE)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, disponibilita);
            stmt.setString(4, tipo);
            stmt.setString(5, id);
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
