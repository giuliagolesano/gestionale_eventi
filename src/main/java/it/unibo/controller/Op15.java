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
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private DatePicker dataComportamentoIllecito;
    @FXML
    private TextField descrizioneComportamento;
    @FXML
    private TextField id;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setBlockedClient(nome.getText(), cognome.getText(), Date.valueOf(dataComportamentoIllecito.getValue()), descrizioneComportamento.getText(), id.getText());
    }

    public void setBlockedClient(String nome, String cognome, java.sql.Date dataComportamentoIllecito, String descrizioneComportamento, String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_BLOCKED_CLIENT)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setDate(3, dataComportamentoIllecito);
            stmt.setString(4, descrizioneComportamento);
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
