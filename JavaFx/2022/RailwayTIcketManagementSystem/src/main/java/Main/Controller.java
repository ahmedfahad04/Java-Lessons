package Main;

/**
 * Sample Skeleton for 'main.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static Main.FXMLManager.LoadFXML;

public class Controller {

    @FXML // fx:id="headerInfo"
    private Label headerInfo; // Value injected by FXMLLoader

    @FXML // fx:id="adminBtn"
    private Button adminBtn; // Value injected by FXMLLoader

    @FXML // fx:id="userBtn"
    private Button userBtn; // Value injected by FXMLLoader


    @FXML
    void onAdminButtonClick(ActionEvent event) throws IOException {
        LoadFXML(event.getSource(), "/Login/login.fxml");
    }

    @FXML
    void onUserButtonClick(ActionEvent event) throws IOException {
        LoadFXML(event.getSource(), "/Login/login.fxml");
    }

}
