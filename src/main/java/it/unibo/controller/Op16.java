package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.ResultSet;

public class Op16 {
    
    @FXML
    private TextField nome;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        viewParticipantsTable(nome.getText());
    }

    public void viewParticipantsTable(String nome) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.VIEW_PARTICIPANTS_TABLE)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int numeroPartecipanti = rs.getInt("Numero_Partecipanti");
                System.out.println("Numero partecipanti al tavolo " + nome + ": " + numeroPartecipanti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
