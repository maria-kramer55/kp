package Client;

import Entity.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Enum.ConnectInstance;

import java.util.ArrayList;

public class OrdersProcessing {

    public static ObservableList<Order> returnOrders() {
        ArrayList<Order> list = ConnectInstance.INSTANCE.getInstance().receiveOrderTable();
        ObservableList<Order> orders = FXCollections.observableArrayList(list);
        return orders;
    }

}
