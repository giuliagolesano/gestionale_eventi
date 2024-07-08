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
import java.util.UUID;

public class Op8 {

    @FXML
    private DatePicker Data_EVENTO;
    @FXML
    private TextField id_CLIENTE;
    @FXML
    private TextField Costo;
    @FXML
    private DatePicker Data_Acquisto;
    @FXML
    private TextField Metodo_Pagamento;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewPresale(Date.valueOf(Data_EVENTO.getValue()), generateUniqueId(), id_CLIENTE.getText(), Integer.parseInt(Costo.getText()), Date.valueOf(Data_Acquisto.getValue()), Metodo_Pagamento.getText());
    }

    private String generateUniqueId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.length() > 30 ? uuid.substring(0, 30) : uuid;
    }

    public void addNewPresale(java.sql.Date Data_EVENTO, String Id, String id_CLIENTE, int Costo, java.sql.Date Data_Acquisto, String Metodo_Pagamento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_PRESALE)) {
            stmt.setDate(1, Data_EVENTO);
            stmt.setString(2, Id);
            stmt.setString(3, id_CLIENTE);
            stmt.setInt(4, Costo);
            stmt.setDate(5, Data_Acquisto);
            stmt.setString(6, Metodo_Pagamento);
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
