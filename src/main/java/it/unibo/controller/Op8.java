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

public class Op8 {

    @FXML
    private DatePicker DataEvento;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField costo;
    @FXML
    private DatePicker DataAcquisto;
    @FXML
    private TextField metodoPagamento;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewPresale(Date.valueOf(DataEvento.getValue()), generateUniqueId(), idCliente.getText(), Integer.parseInt(costo.getText()), Date.valueOf(DataAcquisto.getValue()), metodoPagamento.getText());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addNewPresale(java.sql.Date dataEvento, String id, String idCliente, int costo, java.sql.Date dataAcquisto, String metodoPagamento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_PRESALE)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, id);
            stmt.setString(3, idCliente);
            stmt.setInt(4, costo);
            stmt.setDate(5, dataAcquisto);
            stmt.setString(6, metodoPagamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
