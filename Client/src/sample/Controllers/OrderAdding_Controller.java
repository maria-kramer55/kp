package sample.Controllers;/*
package sample.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import command.client.LogIn;
import command.MaterialsPrcessing;
import command.ServicesProcessing;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import connection.ConnectInstance;

public class OrderAdding_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label clientName;

    @FXML
    private ComboBox<String> serviceComboBox;

    @FXML
    private ComboBox<String> materialsComboBox;

    @FXML
    private Button serviceRegistrationButton;

    @FXML
    private Label servicePrice;

    @FXML
    private DatePicker datePicker;

    @FXML
    void chooseMaterial(ActionEvent event) {
        serviceComboBox.getValue();


    }

    @FXML
    void chooseService(ActionEvent event) {

    }

    @FXML
    void pickDate(ActionEvent event) {

    }

    @FXML
    void registService(ActionEvent event) {
       LocalDate date =  datePicker.getValue();

        ConnectInstance.INSTANCE.getInstance().post("AddOrder "+date+" "+LogIn.clientName+" "+LogIn.clientLastName+" "+serviceComboBox.getValue()+" "+materialsComboBox.getValue());
    }

    @FXML
    void initialize() {
        clientName.setText(LogIn.clientName + " " + LogIn.clientLastName);
        ConnectInstance.INSTANCE.getInstance().post("returnServices .");
        serviceComboBox.setItems(ServicesProcessing.services());

        servicePrice.setVisible(false);

        ConnectInstance.INSTANCE.getInstance().post("MaterialTableCreate .");
        materialsComboBox.setItems(FXCollections.observableArrayList(MaterialsPrcessing.materialByService()));

    }
}
*/
