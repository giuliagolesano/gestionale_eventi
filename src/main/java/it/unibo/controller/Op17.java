package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Op17 {
    
    @FXML
    private TextField nome;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        viewParticipantsList(nome.getText());
    }

    public void viewParticipantsList(String nome) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.VIEW_PARTICIPANTS_LIST)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int numeroIscritti = rs.getInt("Numero_Iscrizioni");
                System.out.println("Numero iscritti alla lista " + nome + ": " + numeroIscritti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
