package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;

public class Op21 {
    
    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        getBestPR();
    }

    public void getBestPR() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.BEST_PR)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomePR = rs.getString("Nome");
                String cognomePR = rs.getString("Cognome");
                int incassoTotale = rs.getInt("IncassoTotale");
                System.out.println("Miglior PR: " + nomePR + " " + cognomePR + ", Incasso totale: " + incassoTotale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
