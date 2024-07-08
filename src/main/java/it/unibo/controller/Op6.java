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

public class Op6 {
    
    @FXML
    private DatePicker Data_EVENTO;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Costo_Adesione;
    @FXML
    private DatePicker Data_Iscrizione;
    @FXML
    private TextField Numero_Iscrizioni;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewList(Date.valueOf(Data_EVENTO.getValue()), Nome.getText(), Integer.parseInt(Costo_Adesione.getText()), Date.valueOf(Data_Iscrizione.getValue()), Integer.parseInt(Numero_Iscrizioni.getText()));
    }

    public void addNewList(Date Data_EVENTO, String Nome, int Costo_Adesione, Date Data_Iscrizione, int Numero_Iscrizioni) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_LIST)) {
            stmt.setDate(1, Data_EVENTO);
            stmt.setString(2, Nome);
            stmt.setInt(3, Costo_Adesione);
            stmt.setDate(4, Data_Iscrizione);
            stmt.setInt(5, Numero_Iscrizioni);
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
