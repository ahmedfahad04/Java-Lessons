package sample;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SecondController {
    public void gotofirst(ActionEvent actionEvent) throws IOException {
        AllStages.FIRST().show();
    }

    public void closeStage2(ActionEvent actionEvent) {
    }
}
