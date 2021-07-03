package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AllStages {
    public static Stage FIRST() throws IOException {
        Parent second = FXMLLoader.load(Objects.requireNonNull(AllStages.class.getResource("Second.fxml")));
        Scene sc = new Scene(second);
        Stage st = new Stage();
        st.setScene(sc);
        return st;
    }

    public static Stage SECOND() throws IOException{
        Parent second = FXMLLoader.load(Objects.requireNonNull(AllStages.class.getResource("First.fxml")));
        Scene sc = new Scene(second);
        Stage st = new Stage();
        st.setScene(sc);
        return st;
    }
}
