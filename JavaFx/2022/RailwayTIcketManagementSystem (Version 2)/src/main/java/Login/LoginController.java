package Login;

import Main.Admin;
import Main.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static Main.FXMLManager.LoadFXML;
import static Main.newTicketBookingController.userInfo;

public class LoginController extends Thread {

    @FXML
    public TextField txtname;

    @FXML
    public PasswordField txtpass;

    @FXML
    private Button registerWindow;


    public void onClickRegisterWindow(MouseEvent event) throws IOException {
        System.out.println("Within Register Window");
        LoadFXML(event.getSource(), "/Registration/registration.fxml");
    }

    public void clickonEvent(MouseEvent actionEvent) throws IOException {
        String myname = txtname.getText();
        String mypass = txtpass.getText();


        if (Integer.parseInt(mypass) < 200) {
            Admin admin = new Admin();
            // will handle this case later
            admin.Login(myname, mypass);

        } else {
            Customer user = new Customer();
            user.Name = myname;
            user.customerID = Integer.parseInt(mypass);

            user.Login(myname, mypass, actionEvent);
            userInfo(user);
        }

    }

    public void closeEvent(MouseEvent mouseEvent) {
        System.exit(1);
        System.out.println("Button pressed!");
    }

}
