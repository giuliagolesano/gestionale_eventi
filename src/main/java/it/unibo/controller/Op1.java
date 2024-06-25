package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.util.UUID;

public class Op1 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private CheckBox consenso;
    @FXML    
    private TextField sesso;
    @FXML
    private DatePicker DataNascita;
    @FXML
    private TextField numeroTelefono;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewClient(nome.getText(), cognome.getText(), generateUniqueId() ,consenso.isSelected(), sesso.getText(), Date.valueOf(DataNascita.getValue()), numeroTelefono.getText());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addNewClient(String nome, String cognome, String id, boolean consenso, String sesso, Date dataNascita, String numeroTelefono) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_CLIENT)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, id);
            stmt.setBoolean(4, consenso);
            stmt.setString(5, sesso);
            stmt.setDate(6, dataNascita);
            stmt.setString(7, numeroTelefono);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
