package Client;

import Entity.Worker;
import  Enum.ConnectInstance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class WorkersProcessing {

    public static ObservableList<Worker> returnAllWorkers(){
        ArrayList<Worker> list = ConnectInstance.INSTANCE.getInstance().receiveWorkerTable();
        ObservableList<Worker> workers = FXCollections.observableArrayList(list);
        return workers;
    }
}