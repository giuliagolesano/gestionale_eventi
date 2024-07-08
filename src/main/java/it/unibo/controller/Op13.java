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

public class Op13 {

    @FXML
    private TextField Password;    
    @FXML
    private TextField Costo_per_Partecipante;
    @FXML
    private TextField Posizione;
    @FXML
    private TextField id_PR;
    @FXML
    private DatePicker Data_EVENTO;
    @FXML
    private TextField Nome;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setTable(Nome.getText(), Password.getText(), Integer.parseInt(Costo_per_Partecipante.getText()), Posizione.getText(), id_PR.getText(), Date.valueOf(Data_EVENTO.getValue()));
    }

    public void setTable(String Nome, String Password, int Costo_per_Partecipante, String Posizione, String id_PR, java.sql.Date Data_EVENTO) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_TABLE)) {
            stmt.setString(2, Password);
            stmt.setInt(3, Costo_per_Partecipante);
            stmt.setString(4, Posizione);
            stmt.setString(5, id_PR);
            stmt.setDate(6, Data_EVENTO);
            stmt.setString(7, Nome);
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
