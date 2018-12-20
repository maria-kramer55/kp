package sample.Controllers;

import command.client.AllClients;
import connection.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import model.Client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UserMenu_Controller {

    @FXML
    private ResourceBundle resources;


    @FXML
    private Label clientName;

    @FXML
    private URL location;

    @FXML
    private TableView<Client> ClientTable;

    @FXML
    private Button updateBttn;

    @FXML
    void updateTable(ActionEvent event) {
        fillTable();
    }

    @FXML
    void initialize() {
        fillTable();
    }


    void fillTable() {
        AllClients clients = new AllClients();
        Connection.getInstance().post("clientsTable ");
        clients.processServerMessage();
        List<Client> clients1 = clients.getClients();
        ObservableList<Client> clientObservableList = FXCollections.observableList(clients1);
        ClientTable.setItems(clientObservableList);
    }
}


