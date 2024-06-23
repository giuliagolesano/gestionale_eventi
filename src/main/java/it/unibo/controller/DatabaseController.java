package it.unibo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unibo.util.Queries;

public class DatabaseController {
    
    public static final String URL = "jdbc:mysql://localhost:3306/gestionale_eventi";
    public static final String USER = "root"; 
    public static final String PASSWORD = "";

    public void addNewClient(String nome, String cognome, String id, boolean consenso, String sesso, java.sql.Date dataNascita, String numeroTelefono) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_CLIENT)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, id);
            stmt.setBoolean(4, consenso);
            stmt.setString(5, sesso);
            stmt.setDate(6, dataNascita);
            stmt.setString(7, numeroTelefono);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewEvent(java.sql.Date data, String tema) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_EVENT)) {
            stmt.setDate(1, data);
            stmt.setString(2, tema);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addLoadDrink(String codice, String nome, String tipologia, java.sql.Date dataAcquisto, java.sql.Date dataScadenza) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_LOAD_DRINK)) {
            stmt.setString(1, codice);
            stmt.setString(2, nome);
            stmt.setString(3, tipologia);
            stmt.setDate(4, dataAcquisto);
            stmt.setDate(5, dataScadenza);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addNewTable(java.sql.Date dataEvento, String nome, String password, int costoPerPartecipante, int posizione, String idUnivocoPR) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_TABLE)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, nome);
            stmt.setString(3, password);
            stmt.setInt(4, costoPerPartecipante);
            stmt.setInt(5, posizione);
            stmt.setString(6, idUnivocoPR);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewPresale(java.sql.Date dataEvento, String id, String idCliente, int costo, java.sql.Date dataAcquisto, String metodoPagamento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_PRESALE)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, id);
            stmt.setString(3, idCliente);
            stmt.setInt(4, costo);
            stmt.setDate(5, dataAcquisto);
            stmt.setString(6, metodoPagamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClientToTable(String idCliente, String nomeTavolo, java.sql.Date dataEvento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_CLIENT_TABLE)) {
            stmt.setString(1, idCliente);
            stmt.setString(2, nomeTavolo);
            stmt.setDate(3, dataEvento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClientToList(String idCliente, String nomeLista, java.sql.Date dataEvento, java.sql.Date dataIscrizione) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_CLIENT_LIST)) {
            stmt.setString(1, idCliente);
            stmt.setString(2, nomeLista);
            stmt.setDate(3, dataEvento);
            stmt.setDate(4, dataIscrizione);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewBlocked(String nome, String cognome, java.sql.Date dataComportamentoIllecito, String descrizioneComportamento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_BLOCKED)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setDate(3, dataComportamentoIllecito);
            stmt.setString(4, descrizioneComportamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewFreePass(java.sql.Date dataEvento, String nome, String cognome, String codice, String idUnivoco, String categoriaOmaggio) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.ADD_NEW_FREE_PASS)) {
            stmt.setDate(1, dataEvento);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, codice);
            stmt.setString(5, idUnivoco);
            stmt.setString(6, categoriaOmaggio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTable(String nome, String password, int costoPerPartecipante, int posizione, String idPR, java.sql.Date dataEvento) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_TABLE)) {
            stmt.setString(1, nome);
            stmt.setString(2, password);
            stmt.setInt(3, costoPerPartecipante);
            stmt.setInt(4, posizione);
            stmt.setString(5, idPR);
            stmt.setDate(6, dataEvento);
            stmt.setString(7, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setEmployee(String nome, String cognome, boolean disponibilita, String tipo, String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_EMPLOYEE)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setBoolean(3, disponibilita);
            stmt.setString(4, tipo);
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBlockedClient(String nome, String cognome, java.sql.Date dataComportamentoIllecito, String descrizioneComportamento, String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_BLOCKED_CLIENT)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setDate(3, dataComportamentoIllecito);
            stmt.setString(4, descrizioneComportamento);
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setEvent(String tema, java.sql.Date data, String codice) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(Queries.SET_EVENT)) {
            stmt.setString(1, tema);
            stmt.setDate(2, data);
            stmt.setString(3, codice);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
