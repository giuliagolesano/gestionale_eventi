package it.unibo.controller;

import it.unibo.util.HibernateUtil;
import it.unibo.util.Queries;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.io.IOException;
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
        String uuid = UUID.randomUUID().toString();
        return uuid.length() > 30 ? uuid.substring(0, 30) : uuid;
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
            query.setParameter(8, null); // LISTA_Data_EVENTO
            query.setParameter(9, null); // Ade_Nome
            query.setParameter(10, null); // TAVOLO_Data_EVENTO
            query.setParameter(11, null); // Isc_Nome

            int result = query.executeUpdate();
            System.out.println(result + " record(s) inserito/i.");

            transaction.commit();
            System.out.println("Transazione completata con successo.");
            
        } catch (Exception e) {
            System.out.println("Errore durante l'operazione: " + e.getMessage());
            showError("Operation failed: " + e.getMessage());
        }
    }

    private void loadConfirmationWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/it/unibo/view/Confirmation.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Conferma");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showError("Unable to load confirmation window.");
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
