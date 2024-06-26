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
    private DatePicker Data_EVENTO;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Password;    
    @FXML
    private TextField Costo_per_Partecipante;
    @FXML
    private TextField Posizione;
    @FXML
    private TextField id_PR;
    @FXML
    private TextField Numero_Partecipanti;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewTable(Date.valueOf(Data_EVENTO.getValue()), Nome.getText(), Password.getText(), Integer.parseInt(Costo_per_Partecipante.getText()), Posizione.getText(), id_PR.getText(), Integer.parseInt(Numero_Partecipanti.getText()));
    }

    public void addNewTable(java.sql.Date Data_EVENTO, String Nome, String Password, int Costo_per_Partecipante, String Posizione, String id_PR, int Numero_Partecipanti) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_TABLE)) {
            stmt.setDate(1, Data_EVENTO);
            stmt.setString(2, Nome);
            stmt.setString(3, Password);
            stmt.setInt(4, Costo_per_Partecipante);
            stmt.setString(5, Posizione);
            stmt.setString(6, id_PR);
            stmt.setInt(7, Numero_Partecipanti);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
