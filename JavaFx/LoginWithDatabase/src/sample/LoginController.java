package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import Database.DbConnection;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button btnsingup;
    @FXML
    private TextField txtpass;
    @FXML
    private TextField txtmail;
    @FXML
    private Button btnlogin;
    @FXML
    private Label lblstatus;




    public void clickonEvent() {

        String usermail = txtmail.getText();
        String userpass = txtpass.getText();

        try {
            String query = "SELECT * From info";
            boolean check = DbConnection.query(query, usermail, userpass);

            if(check){
                lblstatus.setText("Login Successful!!");
                lblstatus.setTextFill(Color.GREEN);
            }
            else{
                lblstatus.setText("Wrong Credentials. Try again!");
                lblstatus.setTextFill(Color.TOMATO);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void clicklogin(KeyEvent keyEvent) throws IOException {

        btnlogin.setOnKeyPressed(
                event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        clickonEvent();
                    }
                }
        );
    }

    public void closeEvent(MouseEvent mouseEvent) {
        System.exit(1);
    }


    @FXML
    public void clicksignup(MouseEvent event) {
        Stage st = (Stage)(((Node)event.getSource()).getScene().getWindow());
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signup.fxml")));
            Scene sc = new Scene(root);
            st.setScene(sc);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
