package Registration;

import Main.Admin;
import Main.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Random;

import static Main.FXMLManager.LoadFXML;

public class RegistrationController {

    @FXML
    private TextField namefld;

    @FXML
    private TextField phonefld;

    @FXML
    private Button registrationBtn;

    @FXML
    private TextField mailfld;

    @FXML
    private Button returnLogin;

    @FXML
    private Label showTokenlbl;

    @FXML
    private RadioButton adminRbtn;

    @FXML
    private RadioButton userRbtn;

    @FXML
    void onClickLoginScreen(ActionEvent event) throws IOException {
        LoadFXML(event.getSource(), "/Login/login.fxml");
    }

    @FXML
    void onClickRegistration(ActionEvent event) throws IOException {
        String Name = namefld.getText();
        String Phone = phonefld.getText();
        String Email = mailfld.getText();
        Random createRandomId = new Random();

        if (adminRbtn.isSelected()) {
            int adminToken = createRandomId.nextInt(199); // will use this token number to get logged into admin account

            Admin admin = new Admin(Email, Phone, Name);
            admin.Register(adminToken);
            showTokenlbl.setText("Use " + adminToken + " number as password");

        } else {
            int userToken = createRandomId.nextInt(100000); // will use this token number to get logged into admin account

            Customer user = new Customer(Email, Phone, Name);
            user.Register(userToken);
            showTokenlbl.setText("Use " + userToken + " number as password");
        }
    }

}
