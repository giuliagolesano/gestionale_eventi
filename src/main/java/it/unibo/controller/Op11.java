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

public class Op11 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private DatePicker Data;
    @FXML
    private TextField descrizioneComportamento;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewBlocked(nome.getText(), cognome.getText(), Date.valueOf(Data.getValue()), descrizioneComportamento.getText());
    }

    public void addNewBlocked(String nome, String cognome, java.sql.Date dataComportamentoIllecito, String descrizioneComportamento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_BLOCKED)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setDate(3, dataComportamentoIllecito);
            stmt.setString(4, descrizioneComportamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
