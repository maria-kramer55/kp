package client;/*
package client;

import model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Enum.ConnectInstance;

import java.util.ArrayList;

public class OrdersProcessing {

    public static ObservableList<Order> returnOrders() {
        ArrayList<Order> list = (ArrayList<Order>) ConnectInstance.INSTANCE.getInstance().receiveWorkerTable();
        ObservableList<Order> orders = FXCollections.observableArrayList(list);
        return orders;
    }

}
*/
