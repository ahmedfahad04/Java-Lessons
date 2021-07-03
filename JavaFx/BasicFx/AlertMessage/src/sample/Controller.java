package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;

public class Controller extends Features {

    @FXML
    private Pane pndone;

    @FXML
    private Pane pnReg;

    @FXML
    private Button btnreg;

    @FXML
    private Button btnBack;

    @FXML
    void clickBackAlert(ActionEvent event) {
        AlertBox("Are you sure to Register");
        pndone.toBack();
        pnReg.toFront();

    }

    @FXML
    void clickalert(ActionEvent event) {
        AlertBox("Are you sure to Back?");
        pndone.toFront();

    }



}

