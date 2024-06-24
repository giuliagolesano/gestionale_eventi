package it.unibo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.sql.Date;
import java.util.UUID;

public class OperationExecutorController {

    @FXML
    private Label operationLabel;

    @FXML
    private TextField param1;
    @FXML
    private TextField param2;
    @FXML
    private TextField param3;
    @FXML
    private CheckBox param4;
    @FXML
    private DatePicker param6;
    @FXML
    private DatePicker param7;
    @FXML
    private ComboBox<String> param8;
    @FXML
    private CheckBox param5;


    private DatabaseController dbController;
    private String selectedOperation;

    public void setDbController(DatabaseController dbController) {
        this.dbController = dbController;
    }

    public void setSelectedOperation(String selectedOperation) {
        this.selectedOperation = selectedOperation;
        operationLabel.setText(selectedOperation);
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    @FXML
    private void executeOperation() {
        /*try {
            switch (selectedOperation) {
                case "Op1: Iscrizione di un Dipendente":
                    dbController.addNewClient(param1.getText(), param2.getText(), generateUniqueId(), param5.isSelected(), param4.getText(), Date.valueOf(param6.getValue()), param3.getText());
                    break;
                case "Op2: Registrazione di un nuovo Evento":
                    dbController.addNewEvent(Date.valueOf(param6.getValue()), param2.getText());
                    break;
                case "Op3: Iscrizione di un Dipendente impiegato in un Evento":
                    dbController.addEmployeeToEvent(Date.valueOf(param6.getValue()), param1.getText());
                    break;
                case "Op4: Registrazione di un nuovo carico di Bevande":
                    dbController.addLoadDrink(param1.getText(), param2.getText(), param3.getText(), Date.valueOf(param6.getValue()), Date.valueOf(param7.getValue()));
                    break;
                case "Op5: Iscrizione di una nuova Lista":
                    dbController.addNewList(param1.getText(), Integer.parseInt(param2.getText()), Integer.parseInt(param3.getText()));
                    break;
                case "Op6: Registrazione di un nuovo Tavolo da un PR":
                    dbController.addNewTable(Date.valueOf(param6.getValue()), param1.getText(), param2.getText(), Integer.parseInt(param3.getText()), Integer.parseInt(param4.getText()), generateUniqueId());
                    break;
                case "Op7: Iscrizione di un Cliente ad una Prevendita":
                    dbController.addNewPresale(Date.valueOf(param6.getValue()), param1.getText(), generateUniqueId(), Integer.parseInt(param2.getText()), Date.valueOf(param7.getValue()), param8.getValue());
                    break;
                case "Op8: Iscrizione di un Cliente ad un Tavolo":
                    dbController.addClientToTable(param1.getText(), param2.getText(), Date.valueOf(param6.getValue()));
                    break;
                case "Op9: Iscrizione di un Cliente ad una Lista":
                    dbController.addClientToList(param1.getText(), param2.getText(), Date.valueOf(param6.getValue()), Date.valueOf(param7.getValue()));
                    break;
                case "Op10: Iscrizione di un nuovo Cliente Bloccato":
                    dbController.addNewBlocked(param1.getText(), param2.getText(), Date.valueOf(param6.getValue()), param3.getText());
                    break;
                case "Op11: Iscrizione di un nuovo Omaggio":
                    dbController.addNewFreePass(Date.valueOf(param6.getValue()), param1.getText(), param2.getText(), generateUniqueId(), generateUniqueId(), param3.getText());
                    break;
                case "Op12: Modifica dei dati di un Tavolo già registrato":
                    dbController.setTable(param1.getText(), param2.getText(), Integer.parseInt(param3.getText()), Integer.parseInt(param4.getText()), generateUniqueId(), Date.valueOf(param6.getValue()));
                    break;
                case "Op13: Modifica dei dati di un Dipendente già registrato":
                    dbController.setEmployee(param1.getText(), param2.getText(), param5.isSelected(), param3.getText(), generateUniqueId());
                    break;
                case "Op14: Modifica dei dati di un Cliente Bloccato già registrato":
                    dbController.setBlockedClient(param1.getText(), param2.getText(), Date.valueOf(param6.getValue()), param3.getText(), generateUniqueId());
                    break;
                case "Op15: Modifica dei dati di un Evento già registrato":
                    dbController.setEvent(param2.getText(), Date.valueOf(param6.getValue()), generateUniqueId());
                    break;
                case "Op16: Scelta di una Bevanda da parte di un Tavolo":
                    dbController.addLoadDrink(param1.getText(), param2.getText(), param3.getText(), Date.valueOf(param6.getValue()), Date.valueOf(param7.getValue()));
                    break;
                case "Op17: Visualizzazione del numero di persone iscritte ad una Lista":
                    dbController.viewParticipantsList(param1.getText());
                    break;
                case "Op18: Visualizzazione del numero di Bevande contenute nel Menù":
                    dbController.viewTotalMenu(param1.getText());
                    break;
                default:
                    showAlert("Operazione non supportata!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Errore durante l'esecuzione dell'operazione!");
        }*/
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attenzione");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
