package sample.Controllers;/*
package sample.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import command.MaterialsPrcessing;
import command.ServicesProcessing;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import connection.ConnectInstance;
import sample.AlertBox;

public class AdministratorOrderAdding_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private TextField clientName;

    @FXML
    private TextField clientLastName;

    @FXML
    void chooseMaterial(ActionEvent event) {

    }

    @FXML
    void chooseService(ActionEvent event) {

    }

    @FXML
    void pickDate(ActionEvent event) {

    }

    @FXML
    void registService(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        if (date != null && clientName.getText() != null && clientLastName.getText() != null && serviceComboBox.getValue() != null) {
            ConnectInstance.INSTANCE.getInstance().post("AddOrder " + date + " " + clientName.getText() + " " + clientLastName.getText() + " " + serviceComboBox.getValue() + " " + materialsComboBox.getValue());
            AlertBox.display("SUCCESS", "Запись успешно добавлена!");
        }
        else AlertBox.display("WARNING", "Заполните поля!!");
    }


    @FXML
    void initialize() {
        ConnectInstance.INSTANCE.getInstance().post("returnServices .");
        serviceComboBox.setItems(ServicesProcessing.services());

        servicePrice.setVisible(false);

        ConnectInstance.INSTANCE.getInstance().post("MaterialTableCreate .");
        materialsComboBox.setItems(FXCollections.observableArrayList(MaterialsPrcessing.materialByService()));


    }
}

*/
