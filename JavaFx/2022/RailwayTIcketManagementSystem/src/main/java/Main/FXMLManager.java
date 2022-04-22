package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FXMLManager {

    public static <T> void LoadFXML(T event, String fxmlName) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(FXMLManager.class.getResource(fxmlName)));
        Stage stage = (Stage) ((Node) event).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
