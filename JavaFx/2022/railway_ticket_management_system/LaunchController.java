package railway_ticket_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class LaunchController {

    @FXML
    private Label headerInfo;

    @FXML
    private Button adminBtn;

    @FXML
    private Button userBtn;

    final <T> void LoadFXML(T event, String fxmlName) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlName));
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlName)));
        Stage stage = (Stage) ((Node) event).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    };

    @FXML
    void onAdminButtonClick(ActionEvent event) throws IOException {
        System.out.println("Show admin page");
        LoadFXML(event.getSource(), "/Login/sample/sample.fxml");
    }

    @FXML
    void onUserButtonClick(ActionEvent event) {
        System.out.println("Show user page");
    }

}
