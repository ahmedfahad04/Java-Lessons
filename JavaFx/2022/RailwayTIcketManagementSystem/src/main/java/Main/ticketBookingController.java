package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class ticketBookingController extends Thread implements Initializable{

        @FXML
        private TextField addressFrom;

        @FXML
        private TextField addressTo;

        @FXML
        private Button findTicketBtn;

        @FXML
        private DatePicker date;

        BufferedReader reader;
        PrintWriter writer;
        Socket socket;

        public void connectSocket() {
            try {
                socket = new Socket("localhost", 5555);
                System.out.println("Socket is connected with server!");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                this.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        void onFindTicketBtnClick(ActionEvent event) {

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
            connectSocket();
        }
}
