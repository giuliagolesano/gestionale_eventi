package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Op19 {
    
    @FXML
    private TextField Id;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        viewTotalMenu(Id.getText());
    }
    
    public void viewTotalMenu(String Id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.VIEW_TOTAL_MENU)) {
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int numeroBevande = rs.getInt("Numero_di_Bevande");
                System.out.println("Numero totale di bevande nel menu: " + numeroBevande);
            }
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
