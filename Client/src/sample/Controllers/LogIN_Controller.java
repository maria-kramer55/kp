package sample.Controllers;

import java.io.IOException;
import java.net.URL;

import Enum.ConnectInstance;
import Client.LogIn;
import Enum.TransitionInstance;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.AlertBox;

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
    void LogIN(ActionEvent event) {

        if (LogIN_login.getText()!=null && LogIN_Password.getText()!=null) {
            ConnectInstance.INSTANCE.getInstance().Send("logIn " + LogIN_login.getText().trim() + " " + LogIN_Password.getText().trim());
        }else AlertBox.display("WARNING", "Заполните все поля!");


        LogIn.Access();
        if (LogIn.access.equals("0")){
            AlertBox.display("ERROR", "Неправильный логин или пароль!");
        }

        if(LogIn.access.equals("1")) {
           LogIN_Button.getScene().getWindow().hide();
            TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/UserMenu.fxml");
        }

        if (LogIn.access.equals("2")){
            LogIN_Button.getScene().getWindow().hide();
            TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/Administrator.fxml");
        }

        if (LogIn.access.equals("3")){
            LogIN_Button.getScene().getWindow().hide();
            TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/DirectorWork.fxml");
        }



    }

    @FXML
    void Open_Registration_Scene(ActionEvent event) {
            Registration_Button.getScene().getWindow().hide();

            FXMLLoader load  = new FXMLLoader();
            load.setLocation(getClass().getResource("/sample/Scenes/SignUP.fxml"));

            try{
                load.load();
            }catch (IOException e){
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

