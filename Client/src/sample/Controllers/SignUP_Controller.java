package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Enum.ConnectInstance;
import Enum.TransitionInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUP_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void signUp(ActionEvent event) {
        String gender = null;
        if (signUpCheckBoxMale.isSelected()){
            gender = "Male";
        }
        else {gender = "Female";}

        ConnectInstance.INSTANCE.getInstance().Send("sighUp "+signUpName.getText()+" "+signUpLastName.getText()+" "+gender+" "+signUpLogin.getText()+" "+signUpPassword.getText());
        signUpCheckBoxFemale.getScene().getWindow().hide();
        TransitionInstance.INSTANCE.getInstance().transit("/sample/Scenes/LogIN.fxml");




    }


}

