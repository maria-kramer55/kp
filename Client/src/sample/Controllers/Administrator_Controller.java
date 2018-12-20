package sample.Controllers;/*
package sample.Controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import client.OrdersProcessing;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Order;
import Enum.ConnectInstance;
import Enum.TransitionInstance;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.AlertBox;


public class Administrator_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Order> ClientTable;

    @FXML
    private TableColumn<Order, Integer> orderNumber;

    @FXML
    private TableColumn<Order, Date> orderDate;

    @FXML
    private TableColumn<Order, String> orderClientName;

    @FXML
    private TableColumn<Order, String> orderClientLastName;

    @FXML
    private TableColumn<Order, String> orderService;

    @FXML
    private TableColumn<Order, String> orderMaster;

    @FXML
    private TableColumn<Order, String> orderMaterial;

    @FXML
    private TableColumn<Order, String> orderPrice;

    @FXML
    private Button oderAddinButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteOrderButton;


    @FXML
    void Table(ActionEvent event) {

    }

    @FXML
    void initialize() {
        fillTable();
    }

    @FXML
    void DeleteOrder(ActionEvent event) {
        if (ClientTable.getSelectionModel().getSelectedItem() != null) {
            ConnectInstance.INSTANCE.getInstance().post("DeleteOrder "+ClientTable.getSelectionModel().getSelectedItem().getOrderId());
            AlertBox.display("SUCCESS", "Запись успешно удалена!");
        }
        else AlertBox.display("WARNING","Выберите поле!");


    }

    @FXML
    void addOrder(ActionEvent event) {
         TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/OrderAddingByAdministrator.fxml");
    }

    @FXML
    void updateTable(ActionEvent event) {
        fillTable();
    }

    void fillTable(){
        ConnectInstance.INSTANCE.getInstance().post("OrderTableCreate .");

        ObservableList<Order> orders = OrdersProcessing.returnOrders();

        orderNumber.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        orderClientName.setCellValueFactory(new PropertyValueFactory<>("ClientName"));
        orderClientLastName.setCellValueFactory(new PropertyValueFactory<>("ClientLastName"));
        orderService.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        orderMaster.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        orderMaterial.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("orderPrice"));

        ClientTable.setItems(orders);
    }
}


*/
