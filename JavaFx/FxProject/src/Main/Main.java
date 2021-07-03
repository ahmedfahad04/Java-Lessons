package Main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Modality;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        Stage st = new Stage();
        primaryStage.initStyle(StageStyle.UTILITY);
        st.initStyle(StageStyle.DECORATED);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(300);

        st.setMinHeight(500);
        st.setMinWidth(300);



        primaryStage.show();
        st.showAndWait();
    }

}
