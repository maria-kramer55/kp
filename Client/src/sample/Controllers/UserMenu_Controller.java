package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Client.OrdersProcessing;
import Entity.Order;
import Enum.TransitionInstance;
import Enum.ConnectInstance;
import Client.LogIn;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.AlertBox;

public class UserMenu_Controller {

    @FXML
    private ResourceBundle resources;


    @FXML
    private Label clientName;

    @FXML
    private URL location;

    @FXML
    private TableView<Order> ClientTable;

    @FXML
    private TableColumn<Order, Integer> orderNumber;

    @FXML
    private TableColumn<Order, String> orderDate;

    @FXML
    private TableColumn<Order, String> orderService;

    @FXML
    private TableColumn<Order, String> orderMaster;

    @FXML
    private TableColumn<Order, String> orderMaterial;

    @FXML
    private TableColumn<Order, Integer> orderPrice;

    @FXML
    private Button updateBttn;

    @FXML
    private Button newOrderButton;

    @FXML
    private Button orderDeleter;

    @FXML
    void createNewOrder(ActionEvent event) {
       //newOrderButton.getScene().getWindow().hide();
       TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/OrderAdding.fxml");

    }

    @FXML
    void deleteOrder(ActionEvent event){
        if(ClientTable.getSelectionModel() == null){
            AlertBox.display("WARNING", "Выберите запись!");
        }
        else ConnectInstance.INSTANCE.getInstance().Send("DeleteOrder "+ClientTable.getSelectionModel().getSelectedItem().getOrderId());
    }

    @FXML
    void updateTable(ActionEvent event) {
        fillTable();
    }

    @FXML
    void initialize() {
        clientName.setText(LogIn.clientName + " " + LogIn.clientLastName);
        fillTable();
    }


    void fillTable(){

        String name = LogIn.clientName;
        String lastName = LogIn.clientLastName;
        ConnectInstance.INSTANCE.getInstance().Send("OrdersByClientId "+name +" "+lastName);
        ObservableList<Order> orders = OrdersProcessing.returnOrders();

        orderNumber.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        orderService.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        orderMaster.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        orderMaterial.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("orderPrice"));

        ClientTable.setItems(orders);
    }
}

