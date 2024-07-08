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

public class Op10 {
    
    @FXML
    private TextField idCliente;
    @FXML
    private TextField nome;
    @FXML
    private DatePicker DataEvento;
    @FXML
    private DatePicker DataIscrizione;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addClientToList(idCliente.getText(), nome.getText(), Date.valueOf(DataEvento.getValue()), Date.valueOf(DataIscrizione.getValue()));
    }

    public void addClientToList(String idCliente, String nomeLista, java.sql.Date dataEvento, java.sql.Date dataIscrizione) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_CLIENT_LIST)) {
            stmt.setString(1, idCliente);
            stmt.setString(2, nomeLista);
            stmt.setDate(3, dataEvento);
            stmt.setDate(4, dataIscrizione);
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
