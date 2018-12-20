package Client;

import Entity.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Enum.ConnectInstance;

import java.util.ArrayList;

public class ClientsProcessing {

    public static ObservableList<Client> returnAllClients(){

        ArrayList<Client> table = ConnectInstance.INSTANCE.getInstance().receiveClientTable();
        ObservableList<Client> clientsTable = FXCollections.observableArrayList(table);
        return clientsTable;

    }
}
