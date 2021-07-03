package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignUpController {

    @FXML
    private TextField txtinemail;

    @FXML
    private TextField txtinpass;

    @FXML
    private TextField txtinstitute;

    @FXML
    private Button btnsave;

    @FXML
    private Button btncancel;

    @FXML
    void clickCloseinfo(ActionEvent event) throws IOException {
        System.out.println("Are you SignUpCOntroller.?");
        Stage st = (Stage)(((Node)event.getSource()).getScene().getWindow());
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
            Scene sc = new Scene(root);
            st.setScene(sc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clicksaveinfo(ActionEvent event) throws IOException {

        String name = txtinemail.getText();
        String pass = txtinpass.getText();
        String ins = txtinstitute.getText();

        System.out.println(name + ", " + pass + ", " + ins + "\n");
        System.out.println("Info Saved");


    }



}
