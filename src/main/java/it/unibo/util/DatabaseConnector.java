package it.unibo.util;

import java.sql.*;

/**
 * DATABASECONNECTOR Class.
 */
public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connessione al database stabilita.");
        } catch (SQLException e) {
            System.out.println("Errore durante la connessione al database: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connessione al database chiusa.");
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la chiusura della connessione al database: " + e.getMessage());
        }
    }

}
