package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;

public class Op19 {

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        getTenBestDrinks();
    }

    public void getTenBestDrinks() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.TEN_BEST_DRINKS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeBevanda = rs.getString("Nome");
                int numeroRichieste = rs.getInt("NumeroRichieste");
                System.out.println("Bevanda: " + nomeBevanda + ", Numero Richieste: " + numeroRichieste);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
