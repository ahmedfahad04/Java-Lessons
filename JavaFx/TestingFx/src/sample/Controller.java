package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField mailbtn;
    @FXML
    private TextField passbtn;
    @FXML
    private Label forgotlbl;
    @FXML
    private Label statuslbl;
    @FXML
    private Button signinbtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleMouseEvent(MouseEvent event){
        if(event.getSource() == signinbtn){

        }
    }
}
