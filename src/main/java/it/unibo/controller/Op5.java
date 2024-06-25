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
    private TextField Nome;
    @FXML
    private TextField Tipologia;
    @FXML
    private DatePicker Data_Acquisto;
    @FXML
    private DatePicker Data_Scadenza;
    @FXML
    private TextField Disponibilita;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addLoadDrink(generateUniqueId(), Nome.getText(), Tipologia.getText() , Date.valueOf(Data_Acquisto.getValue()), Date.valueOf(Data_Scadenza.getValue()), Integer.parseInt(Disponibilita.getText()));
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addLoadDrink(String Id, String Nome, String Tipologia, java.sql.Date Data_Acquisto, java.sql.Date Data_Scadenza, int Disponibilita) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_LOAD_DRINK)) {
            stmt.setString(1, Id);
            stmt.setString(2, Nome);
            stmt.setString(3, Tipologia);
            stmt.setDate(4, Data_Acquisto);
            stmt.setDate(5, Data_Scadenza);
            stmt.setInt(6, Disponibilita);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
