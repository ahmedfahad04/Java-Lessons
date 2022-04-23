package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class newTicketBookingController extends Thread implements Initializable {

    @FXML
    private StackPane errorMsgStk;

    @FXML
    private AnchorPane errorPn;

    @FXML
    private Button returnToBookingPage;

    @FXML
    private StackPane registerStk;

    @FXML
    private AnchorPane regPn;

    @FXML
    private TextField addressFrom;

    @FXML
    private TextField addressTo;

    @FXML
    private Button findTicketBtn;

    @FXML
    private DatePicker date;

    DataInputStream reader;
    DataOutputStream writer;
    Socket socket;
    static ActionEvent ac;
    static Customer user;

    public static void userInfo(Customer customer){
        user = customer;
    }

    @FXML
    public void onClickBookingPage() {
        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }

    public void connectSocket() {
        try {

            socket = new Socket("localhost", 5555);
            System.out.println("Socket is connected with server!");

            reader = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onFindTicketBtnClick(ActionEvent event) {

        String from = addressFrom.getText();
        String to = addressTo.getText();
        LocalDate myDate = date.getValue();
        String date = String.valueOf(myDate);
        String response = "";

        String info =  user.Name + "," + user.customerID +  "," + from + "," + to + "," + date;

        try {
            writer.writeUTF(info);
            response = reader.readUTF();

            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(response.equalsIgnoreCase("ERROR")){
            errorPn.toFront();
            errorMsgStk.toFront();
        } else {
            System.out.println("NEW is coming");
        }

    }

    @FXML
    void onDatePickerClick(ActionEvent event) {
        LocalDate myDate = date.getValue();
        System.out.println("FROM: " + addressFrom.getText());
        System.out.println("TO: " + addressTo.getText());
        System.out.println("DATE: " + myDate);

    }


    // always remember ... we'll create a new client of newly created window
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }


}
