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

public class Op9 {
    
    @FXML
    private TextField idCliente;
    @FXML
    private TextField nome;
    @FXML
    private DatePicker DataEvento;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addClientToTable(idCliente.getText(), nome.getText(), Date.valueOf(DataEvento.getValue()));
    }

    public void addClientToTable(String idCliente, String nomeTavolo, java.sql.Date dataEvento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_CLIENT_TABLE)) {
            stmt.setString(1, idCliente);
            stmt.setString(2, nomeTavolo);
            stmt.setDate(3, dataEvento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
