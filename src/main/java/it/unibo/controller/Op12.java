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

public class Op12 {
    
    @FXML
    private DatePicker Data_EVENTO;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private TextField id_CLIENTE;
    @FXML
    private TextField Categoria_Omaggio;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewFreePass(Date.valueOf(Data_EVENTO.getValue()), Nome.getText(), Cognome.getText(), generateUniqueId(), id_CLIENTE.getText(), Categoria_Omaggio.getText());
    }

    private String generateUniqueId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.length() > 30 ? uuid.substring(0, 30) : uuid;
    }

    public void addNewFreePass(java.sql.Date dataEvento, String nome, String cognome, String codice, String idUnivoco, String categoriaOmaggio) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_FREE_PASS)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, codice);
            stmt.setString(5, idUnivoco);
            stmt.setString(6, categoriaOmaggio);
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
