package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unibo.util.Queries;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Op13 {
    
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField dispo;
    @FXML
    private TextField tipo;
    @FXML
    private TextField idDipendente;
 
    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        setEmployee(nome.getText(), cognome.getText(), dispo.getText(), tipo.getText(), idDipendente.getText());
    }

    public void setEmployee(String nome, String cognome, String disponibilita, String tipo, String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_EMPLOYEE)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, disponibilita);
            stmt.setString(4, tipo);
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
