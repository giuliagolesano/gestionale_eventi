package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Op19 {
    
    @FXML
    private TextField id;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        viewTotalMenu(id.getText());
    }
    
    public void viewTotalMenu(String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.VIEW_TOTAL_MENU)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int numeroBevande = rs.getInt("Numero_di_Bevande");
                System.out.println("Numero totale di bevande nel menu: " + numeroBevande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
