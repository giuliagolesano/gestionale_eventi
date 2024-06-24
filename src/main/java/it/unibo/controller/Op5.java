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

public class Op5 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField tipologia;
    @FXML
    private DatePicker DataAcquisto;
    @FXML
    private DatePicker DataScadenza;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addLoadDrink(generateUniqueId(), nome.getText(), tipologia.getText() , Date.valueOf(DataAcquisto.getValue()), Date.valueOf(DataScadenza.getValue()));
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addLoadDrink(String codice, String nome, String tipologia, java.sql.Date dataAcquisto, java.sql.Date dataScadenza) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_LOAD_DRINK)) {
            stmt.setString(1, codice);
            stmt.setString(2, nome);
            stmt.setString(3, tipologia);
            stmt.setDate(4, dataAcquisto);
            stmt.setDate(5, dataScadenza);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
