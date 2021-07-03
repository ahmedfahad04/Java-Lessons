package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    String name = "fahad";
    String pass = "1234";

    @FXML
    public TextField txtname;
    @FXML
    public PasswordField txtpass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void clickonEvent(MouseEvent actionEvent) {
        String myname = txtname.getText();
        String mypass = txtpass.getText();
        if(myname.equals(name) && mypass.equals(pass)){
            System.out.println("Login Successful!!");
        }
        else{
            System.out.println("Wrong Credentials! Try again.");
        }
    }


    public void closeEvent(MouseEvent mouseEvent) {
        System.exit(1);
        System.out.println("Button pressed!");
    }
}
