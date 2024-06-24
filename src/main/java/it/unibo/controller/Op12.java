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

public class Op12 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField password;    
    @FXML
    private TextField costo;
    @FXML
    private TextField posizione;
    @FXML
    private TextField idPR;
    @FXML
    private DatePicker DataEvento;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setTable(nome.getText(), password.getText(), Integer.parseInt(costo.getText()), posizione.getText(), idPR.getText(), Date.valueOf(DataEvento.getValue()));
    }

    public void setTable(String nome, String password, int costoPerPartecipante, String posizione, String idPR, java.sql.Date dataEvento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_TABLE)) {
            stmt.setString(1, nome);
            stmt.setString(2, password);
            stmt.setInt(3, costoPerPartecipante);
            stmt.setString(4, posizione);
            stmt.setString(5, idPR);
            stmt.setDate(6, dataEvento);
            stmt.setString(7, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
