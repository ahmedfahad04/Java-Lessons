package Login;

import Main.Admin;
import Main.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static Main.FXMLManager.LoadFXML;

public class LoginController extends Thread {
    String name = "fahad";
    String pass = "1234";

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
            admin.Login(myname, mypass);

        } else {
            Customer user = new Customer();
            user.Login(myname, mypass);

            System.out.println("WILL ENTER INTO NEW WINDOW");
            LoadFXML(actionEvent.getSource(), "/Main/ticketBooking.fxml"); // this will be changed
        }




    }

    public void closeEvent(MouseEvent mouseEvent) {
        System.exit(1);
        System.out.println("Button pressed!");
    }

}
