package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLTransition {

    public void transit(String pacage){
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource(pacage));

        try {
            load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = load.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
