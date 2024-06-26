package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.UUID;

public class Op3 {
    
    @FXML
    private TextField Disponibilita;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private TextField Tipo;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewEmployee(Disponibilita.getText(), Nome.getText(), Cognome.getText(), generateUniqueId(), Tipo.getText());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addNewEmployee(String Disponibilita, String Nome, String Cognome, String Id, String Tipo) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_EMPLOYEE)) {
            stmt.setString(2, Disponibilita);
            stmt.setString(2, Nome);
            stmt.setString(2, Cognome);
            stmt.setString(2, Id);
            stmt.setString(2, Tipo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
