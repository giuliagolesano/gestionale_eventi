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

public class Op6 {
    
    @FXML
    private DatePicker Data_EVENTO;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Costo_Adesione;
    @FXML
    private DatePicker Data_Iscrizione;
    @FXML
    private TextField Numero_Iscrizioni;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewList(Date.valueOf(Data_EVENTO.getValue()), Nome.getText(), Integer.parseInt(Costo_Adesione.getText()), Integer.parseInt(Numero_Iscrizioni.getText()));
    }

    public void addNewList(Date Data_EVENTO, String Nome, int Costo_Adesione, int Numero_Iscrizioni) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_LIST)) {
            stmt.setDate(1, Data_EVENTO);
            stmt.setString(2, Nome);
            stmt.setInt(3, Costo_Adesione);
            stmt.setInt(4, Numero_Iscrizioni);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
