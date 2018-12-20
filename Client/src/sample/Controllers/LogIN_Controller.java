package sample.Controllers;

import connection.ConnectInstance;
import connection.TransitionInstance;
import command.client.LogIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogIN_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogIN_Button;

    @FXML
    private TextField LogIN_login;

    @FXML
    private PasswordField LogIN_Password;

    @FXML
    private Button Registration_Button;

    @FXML
    public void logIn(ActionEvent event) {
        if (LogIN_login.getText() != null && LogIN_Password.getText() != null) {
            ConnectInstance.INSTANCE.getInstance().post("logIn " + LogIN_login.getText().trim() + " " + LogIN_Password.getText().trim());
        } else AlertBox.display("WARNING", "Заполните все поля!");
        LogIn logIn = new LogIn();
        logIn.processServerMessage();
        LogIN_Button.getScene().getWindow().hide();
        TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/DirectorWork.fxml");
    }

    @FXML
    void Open_Registration_Scene(ActionEvent event) {
        Registration_Button.getScene().getWindow().hide();

        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("/sample/Scenes/SignUP.fxml"));

        try {
            load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = load.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void initialize() {
        ConnectInstance.INSTANCE.getInstance().connect();
    }
}

