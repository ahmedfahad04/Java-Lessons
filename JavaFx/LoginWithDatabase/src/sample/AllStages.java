package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class AllStages extends Stage {

    //define your offsets here
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static Stage signupStage() throws IOException {
        Parent node = FXMLLoader.load(Objects.requireNonNull(AllStages.class.getResource("Signup.fxml")));

        Stage st = new Stage();
        Scene sc = new Scene(node);
        st.setScene(sc);
        st.initStyle(StageStyle.TRANSPARENT);

        //grab your root here
        node.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        //move around here
        node.setOnMouseDragged(event -> {
            st.setX(event.getScreenX() - xOffset);
            st.setY(event.getScreenY() - yOffset);
        });

        System.out.println("I have come in AllStage Now!!");
        return st;
    }


}
