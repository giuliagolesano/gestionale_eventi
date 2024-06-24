package it.unibo.util;

public class Queries {
    /**
     * Query for adding a new client.
     */
    public static final String ADD_NEW_CLIENT = "INSERT INTO Cliente (Nome, Cognome, id, Consenso, Sesso, DataNascita, NumeroTelefono) VALUES (?, ?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a new event.
     */
    public static final String ADD_NEW_EVENT = "INSERT INTO Evento (Data, Tema) VALUES (?, ?);";

    /**
     * Query for adding an employee to an event.
     */
    public static final String ADD_EMPLOYEE_EVENT = "INSERT INTO Impiegati (DataEvento, idUnivoco) VALUES (?, ?);";

    /**
     * Query for adding a new load of drinks.
     */
    public static final String ADD_LOAD_DRINK = "INSERT INTO Bevanda (Codice, Nome, Tipologia, Data_Acquisto, Data_Scadenza) VALUES (?, ?, ?, ?, ?);";

    /**
     * Query for adding a new list.
     */
    public static final String ADD_NEW_LIST = "INSERT INTO Lista (Nome, Costo_Adesione, Numero_Partecipanti) VALUES (?, ?, ?);";

    /**
     * Query for adding a new table by a PR.
     */
    public static final String ADD_NEW_TABLE = "INSERT INTO Tavolo (Data_EVENTO, Nome, Password, Costo_per_Partecipante, Posizione, idUnivoco_PR) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a new presale.
     */
    public static final String ADD_NEW_PRESALE = "INSERT INTO Prevendita_Generica (Data_EVENTO, Id, Id_CLIENTE, Costo, Data_Acquisto, Metodo_Pagamento) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a client to a table.
     */
    public static final String ADD_CLIENT_TABLE = "INSERT INTO PartecipantiTavolo (id_CLIENTE, Nome_TAVOLO, Data_EVENTO) VALUES (?, ?, ?);";

    /**
     * Query for adding a client to a list.
     */
    public static final String ADD_CLIENT_LIST = "INSERT INTO IscrizioniLista (id_CLIENTE, Nome_LISTA, Data_EVENTO, Data_Iscrizione) VALUES (?, ?, ?, ?);";

    /**
     * Query for adding a new blocked client.
     */
    public static final String ADD_NEW_BLOCKED = "INSERT INTO ClientiBloccati (Nome, Cognome, Data_Comportamento_Illecito, Descrizione_Comportamento) VALUES (?, ?, ?, ?);";

    /**
     * Query for adding a new free pass.
     */
    public static final String ADD_NEW_FREE_PASS = "INSERT INTO Omaggio (Data_EVENTO, Nome, Cognome, Codice, idUnivoco, Categoria_Omaggio) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for updating a table.
     */
    public static final String SET_TABLE = "UPDATE Tavolo SET Nome = ?, Password = ?, Costo_per_Partecipante = ?, Posizione = ?, id_PR = ? WHERE Data_EVENTO = ? AND Nome = ?;";

    /**
     * Query for updating an employee.
     */
    public static final String SET_EMPLOYEE = "UPDATE Dipendente SET Nome = ?, Cognome = ?, Disponibilita = ?, Tipo = ? WHERE id = ?;";

    /**
     * Query for updating a blocked client.
     */
    public static final String SET_BLOCKED_CLIENT = "UPDATE Cliente_bloccato SET Nome = ?, Cognome = ?, Data_Comportamento_Illecito = ?, Descrizione_Comportamento = ? WHERE Id = ?;";

    /**
     * Query for updating an event.
     */
    public static final String SET_EVENT = "UPDATE Evento SET Tema = ? WHERE Data = ? AND Tema = ?;";

    /**
     * Query for viewing the number of participants in a table.
     */
    public static final String VIEW_PARTICIPANTS_TABLE = "SELECT Numero_Partecipanti FROM Tavolo WHERE Nome = ?;";

    /**
     * Query for viewing the number of participants in a list.
     */
    public static final String VIEW_PARTICIPANTS_LIST = "SELECT Numero_Iscrizioni FROM Lista WHERE Nome = ?;";

    /**
     * Query for viewing the total number of drinks in the menu.
     */
    public static final String VIEW_TOTAL_MENU = "SELECT Numero_di_Bevande FROM Menu WHERE Id = ?;";

    /**
     * Query for getting the top 10 most requested drinks.
     */
    public static final String TEN_BEST_DRINKS = "SELECT Bevanda.Nome, COUNT(*) as NumeroRichieste FROM Bevanda JOIN Ordine_Bevande ON Bevanda.Id = Ordine_Bevande.Id_BEVANDA GROUP BY Bevanda.Nome ORDER BY NumeroRichieste DESC LIMIT 10;";

    /**
     * Query for getting the table present at the most events.
     */
    public static final String BEST_TABLE = "SELECT Tavolo.Nome, COUNT(*) as NumeroEventi FROM Tavolo GROUP BY Tavolo.Nome ORDER BY NumeroEventi DESC LIMIT 1;";

    /**
     * Query for getting the PR that generated the most revenue.
     */
    public static final String BEST_PR = "SELECT DIPENDENTE.Nome, DIPENDENTE.Cognome, SUM(TAVOLO.Costo_per_Partecipante * TAVOLO.Numero_Partecipanti) AS IncassoTotale FROM DIPENDENTE JOIN TAVOLO ON DIPENDENTE.id = TAVOLO.id_PR WHERE DIPENDENTE.id IN (SELECT id FROM PUBBLICHE_RELAZIONI) GROUP BY DIPENDENTE.Nome, DIPENDENTE.Cognome ORDER BY IncassoTotale DESC LIMIT 1;";
}