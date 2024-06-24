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

public class Op4 {
    
    @FXML
    private DatePicker Data;
    @FXML
    private TextField Id;

    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    @FXML
    private void executeOperation(){
        addEmployeeToEvent(Date.valueOf(Data.getValue()), Id.getText());
    }
    
    public void addEmployeeToEvent(java.sql.Date dataEvento, String idUnivoco) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_EMPLOYEE_EVENT)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, idUnivoco);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
