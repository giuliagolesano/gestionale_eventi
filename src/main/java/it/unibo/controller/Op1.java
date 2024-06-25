package it.unibo.controller;

import it.unibo.util.HibernateUtil;
import it.unibo.util.Queries;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Query;

public class Op1 {
    
    @FXML
    private TextField   Nome;
    @FXML
    private TextField Cognome;
    @FXML
    private CheckBox Consenso;
    @FXML    
    private TextField Sesso;
    @FXML
    private DatePicker Data_Nascita;
    @FXML
    private TextField Numero_Telefono;

    @FXML
    private void executeOperation() {
        addNewClient(Nome.getText(), Cognome.getText(), generateUniqueId(), Consenso.isSelected(), Sesso.getText(), Date.valueOf(Data_Nascita.getValue()), Numero_Telefono.getText());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void addNewClient(String nome, String cognome, String id, boolean consenso, String sesso, Date dataNascita, String numeroTelefono ) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("Connessione al database stabilita con successo.");

            Query query = session.createNativeQuery(Queries.ADD_NEW_CLIENT);
            query.setParameter(1, nome);
            query.setParameter(2, cognome);
            query.setParameter(3, id);
            query.setParameter(4, consenso);
            query.setParameter(5, sesso);
            query.setParameter(6, dataNascita);
            query.setParameter(7, numeroTelefono);

            int result = query.executeUpdate();
            System.out.println(result + " record(s) inserito/i.");

            transaction.commit();
            System.out.println("Transazione completata con successo.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transazione annullata.");
            }
            System.out.println("Errore durante l'operazione: " + e.getMessage());
            showError("Operation failed: " + e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
