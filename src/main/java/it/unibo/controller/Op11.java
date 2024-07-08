package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.util.UUID;

public class Op11 {
    
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private TextField id_CLIENTE;
    @FXML
    private DatePicker Data_Comportamento_Illecito;
    @FXML
    private TextField Descrizione_Comportamento_Illecito;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewBlocked(Nome.getText(), Cognome.getText(), generateUniqueId(), id_CLIENTE.getText(), Date.valueOf(Data_Comportamento_Illecito.getValue()), Descrizione_Comportamento_Illecito.getText());
    }

    private String generateUniqueId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.length() > 30 ? uuid.substring(0, 30) : uuid;
    }

    public void addNewBlocked(String Nome, String Cognome, String Id, String id_CLIENTE, java.sql.Date Data_Comportamento_Illecito, String Descrizione_Comportamento_Illecito) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_BLOCKED)) {
            stmt.setString(1, Nome);
            stmt.setString(2, Cognome);
            stmt.setString(3, Id);
            stmt.setString(4, id_CLIENTE);
            stmt.setDate(5, Data_Comportamento_Illecito);
            stmt.setString(6, Descrizione_Comportamento_Illecito);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
