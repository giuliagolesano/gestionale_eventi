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

public class Op16 {
    
    @FXML
    private TextField tema;
    @FXML
    private DatePicker DataEvento;
    @FXML
    private TextField codice;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setEvent(tema.getText(), Date.valueOf(DataEvento.getValue()), codice.getText());
    }

    public void setEvent(String tema, java.sql.Date data, String codice) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_EVENT)) {
            stmt.setString(1, tema);
            stmt.setDate(2, data);
            stmt.setString(3, codice);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
