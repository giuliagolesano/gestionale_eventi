package it.unibo.util;

public class Queries {
    /**
     * Query for adding a new client.
     */
    public static final String ADD_NEW_CLIENT = "INSERT INTO cliente (Nome, Cognome, id, Consenso, Sesso, Data_Nascita, Numero_Telefono, LISTA_Data_EVENTO, Ade_Nome, TAVOLO_Data_EVENTO, Isc_Nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    /**
     * Query for adding a new event.
     */
    public static final String ADD_NEW_EVENT = "INSERT INTO evento (Data, Tema) VALUES (?, ?);";

    /**
     * Query for adding a new event.
     */
    public static final String ADD_NEW_EMPLOYEE = "INSERT INTO dipendente (Disponibilita, Nome, Cognome,  Id, Tipo) VALUES (?, ?, ?, ?, ?);";

    /**
     * Query for adding an employee to an event.
     */
    public static final String ADD_EMPLOYEE_EVENT = "INSERT INTO impiegati_evento (id_DIPENDENTE, Data_EVENTO) VALUES (?, ?);";

    /**
     * Query for adding a new load of drinks.
     */
    public static final String ADD_LOAD_DRINK = "INSERT INTO bevanda (Id, Nome, Tipologia, Data_Acquisto, Data_Scadenza, Disponibilita) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a new list.
     */
    public static final String ADD_NEW_LIST = "INSERT INTO lista (Data_EVENTO, Nome, Costo_Adesione, Data_Iscrizione, Numero_Iscrizioni) VALUES (?, ?, ?, ?, ?);";

    /**
     * Query for adding a new table by a PR.
     */
    public static final String ADD_NEW_TABLE = "INSERT INTO tavolo (Data_EVENTO, Nome, Password, Costo_per_Partecipante, Posizione, id_PR, Numero_Partecipanti) VALUES (?, ?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a new presale.
     */
    public static final String ADD_NEW_PRESALE = "INSERT INTO prevendita_generica (Data_EVENTO, Id, id_CLIENTE, Costo, Data_Acquisto, Metodo_Pagamento) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a client to a table.
     */
    public static final String ADD_CLIENT_TABLE = "UPDATE cliente SET TAVOLO_Data_EVENTO = ?, Ade_Nome = ? WHERE ID = ?;";

    /**
     * Query for adding a client to a list.
     */
    public static final String ADD_CLIENT_LIST = "UPDATE Cliente SET LISTA_Data_EVENTO = ?, Isc_Nome = ? WHERE ID = ?;";

    /**
     * Query for adding a new blocked client.
     */
    public static final String ADD_NEW_BLOCKED = "INSERT INTO cliente_bloccato (Nome, Cognome, Id, id_CLIENTE, Data_Comportamento_Illecito, Descrizione_Comportamento_Illecito) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for adding a new free pass.
     */
    public static final String ADD_NEW_FREE_PASS = "INSERT INTO omaggio (Data_EVENTO, Nome, Cognome, Id, id_CLIENTE, Categoria_Omaggio) VALUES (?, ?, ?, ?, ?, ?);";

    /**
     * Query for updating a table.
     */
    public static final String SET_TABLE = "UPDATE tavolo SET Password = ?, Costo_per_Partecipante = ?, Posizione = ?, id_PR = ? WHERE Data_EVENTO = ? AND Nome = ?;";

    /**
     * Query for updating an employee.
     */
    public static final String SET_EMPLOYEE = "UPDATE dipendente SET Nome = ?, Cognome = ?, Disponibilita = ?, Tipo = ? WHERE id = ?;";

    /**
     * Query for updating a blocked client.
     */
    public static final String SET_BLOCKED_CLIENT = "UPDATE cliente_bloccato SET Nome = ?, Cognome = ?, Data_Comportamento_Illecito = ?, Descrizione_Comportamento_Illecito = ? WHERE id_CLIENTE = ?;";

    /**
     * Query for updating an event.
     */
    public static final String SET_EVENT = "UPDATE evento SET Tema = ? WHERE Data = ?;";

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
    public static final String VIEW_TOTAL_MENU = "SELECT Numero_di_Bevande FROM menu WHERE Id = ?;";

    /**
     * Query for getting the top 10 most requested drinks.
     */
    public static final String TEN_BEST_DRINKS = "SELECT bevanda.Nome, COUNT(*) as NumeroRichieste FROM bevanda JOIN ordine_Bevande ON bevanda.Id = ordine_Bevande.Id_BEVANDA GROUP BY bevanda.Nome ORDER BY NumeroRichieste DESC LIMIT 10;";

    /**
     * Query for getting the table present at the most events.
     */
    public static final String BEST_TABLE = "SELECT tavolo.Nome, COUNT(*) as NumeroEventi FROM Tavolo GROUP BY Tavolo.Nome ORDER BY NumeroEventi DESC LIMIT 1;";

    /**
     * Query for getting the PR that generated the most revenue.
     */
    public static final String BEST_PR = "SELECT dipendente.Nome, DIPENDENTE.Cognome, SUM(tavolo.Costo_per_Partecipante * tavolo.Numero_Partecipanti) AS IncassoTotale FROM dipendente JOIN tavolo ON dipendente.id = tavolo.id_PR WHERE dipendente.id IN (SELECT id FROM pubbliche_relazioni) GROUP BY dipendente.Nome, dipendente.Cognome ORDER BY IncassoTotale DESC LIMIT 1;";
}
