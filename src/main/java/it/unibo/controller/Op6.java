package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Op6 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField costoAdesione;
    @FXML
    private TextField numeroPartecipanti;


    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addNewList(nome.getText(), Integer.parseInt(costoAdesione.getText()), Integer.parseInt(numeroPartecipanti.getText()));
    }

    public void addNewList(String nome, int costoAdesione, int numeroPartecipanti) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_LIST)) {
            stmt.setString(1, nome);
            stmt.setInt(2, costoAdesione);
            stmt.setInt(3, numeroPartecipanti);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
