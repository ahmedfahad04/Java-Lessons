package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signup.fxml")));
       Scene sc = new Scene(node);

       primaryStage.setTitle("SIGN UP");
       primaryStage.setScene(sc);
       primaryStage.show();
    }
}
