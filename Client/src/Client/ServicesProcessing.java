package Client;

import Entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Enum.ConnectInstance;

import java.util.ArrayList;

public class ServicesProcessing {

    public static ObservableList<Service> createTable() {

        ArrayList<Service> table = ConnectInstance.INSTANCE.getInstance().receiveServicesTable();
        ObservableList<Service> clientsTable = FXCollections.observableArrayList(table);
        return clientsTable;
    }

    public static ObservableList<String> services(){
        ObservableList<Service> list = createTable();
        ArrayList<String> serviceNameList = new ArrayList<>();
        for (Service service : list) {
            serviceNameList.add(service.getServiceName());
        }
        ObservableList<String> str = FXCollections.observableArrayList(serviceNameList);
        return str;
    }
}
