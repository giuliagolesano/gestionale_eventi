package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;

public class Op20 {
    
    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        getBestTable();
    }

    public void getBestTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.BEST_TABLE)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomeTavolo = rs.getString("Nome");
                int numeroEventi = rs.getInt("NumeroEventi");
                System.out.println("Tavolo con più eventi: " + nomeTavolo + ", Numero eventi: " + numeroEventi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}