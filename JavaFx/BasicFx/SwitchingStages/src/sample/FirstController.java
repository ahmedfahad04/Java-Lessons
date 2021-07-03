package sample;

import javafx.event.ActionEvent;
import java.io.IOException;

public class FirstController {

    public void gotosecond(ActionEvent actionEvent) throws IOException {
        AllStages.SECOND().show();
    }

    public void closeStage1(ActionEvent actionEvent) {
    }
}
