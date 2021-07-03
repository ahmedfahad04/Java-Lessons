package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class Features {
    void AlertBox(String msg){
        Alert al = new Alert(Alert.AlertType.CONFIRMATION);
        al.setContentText(msg);
        ButtonType OK = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType Cancel = new ButtonType("No", ButtonBar.ButtonData.NO);
        al.getButtonTypes().setAll(OK,Cancel);
        al.showAndWait();
    }
}
