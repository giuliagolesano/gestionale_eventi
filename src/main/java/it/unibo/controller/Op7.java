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

public class Op7 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField password;    
    @FXML
    private DatePicker DataEvento;
    @FXML
    private TextField costo;
    @FXML
    private TextField posizione;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewTable(Date.valueOf(DataEvento.getValue()), nome.getText(), password.getText(), Integer.parseInt(costo.getText()), posizione.getText(), generateUniqueId());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addNewTable(java.sql.Date dataEvento, String nome, String password, int costoPerPartecipante, String posizione, String idUnivocoPR) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_TABLE)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, nome);
            stmt.setString(3, password);
            stmt.setInt(4, costoPerPartecipante);
            stmt.setString(5, posizione);
            stmt.setString(6, idUnivocoPR);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
