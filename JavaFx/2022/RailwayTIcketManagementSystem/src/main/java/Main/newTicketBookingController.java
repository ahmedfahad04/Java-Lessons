package Main;

import Reservation.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class newTicketBookingController extends Thread implements Initializable {

    @FXML
    private StackPane purchaseStk;

    @FXML
    private AnchorPane purchasePn;

    @FXML
    private Button purchaseBtn;

    @FXML
    private Label destinationlbl;

    @FXML
    private Label timelbl;

    @FXML
    private Label datelbl;

    @FXML
    private Label seatlbl;

    @FXML
    private Label price;

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

    @FXML
    private TextField seatfld;

    @FXML
    private Button returnToBookingPage2;

    @FXML
    private Label billDetailslbl;

    @FXML
    private Label totalBilllbl;

    @FXML
    private StackPane finalMsgStk;

    @FXML
    private AnchorPane finalMsgPn;


    DataInputStream reader;
    DataOutputStream writer;
    Socket socket;
    static Customer user;
    int totalCost, lineNumber;
    String[] scheduleInfo;


    public static void userInfo(Customer customer){

        user = customer;
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
    public void onClickBookingPage() {
        seatlbl.setText("");
        addressTo.setText("");
        addressFrom.setText("");

        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }

    @FXML
    public void onFindTicketBtnClick(ActionEvent event) throws IOException {

        String from = addressFrom.getText();
        String to = addressTo.getText();
        LocalDate myDate = date.getValue();
        String fromattedDate = String.valueOf(myDate);
        String response = "";

        String info =  user.Name + "," + user.customerID +  "," + from + "," + to + "," + fromattedDate;

        try {
            writer.writeUTF(info);
            response = reader.readUTF();

            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        if(response.equalsIgnoreCase("ERROR")){
            errorPn.toFront();
            errorMsgStk.toFront();
        } else {

            FileReader fr;
            BufferedReader br;

            fr = new FileReader("reservation.csv");

            br = new BufferedReader(fr);
            String line;
            int flag = 0;

            while ((line = br.readLine()) != null) { // read a line
                lineNumber++;
                scheduleInfo = line.split(",");

                if (from.equalsIgnoreCase(scheduleInfo[0]) && to.equalsIgnoreCase(scheduleInfo[1]) && fromattedDate.equalsIgnoreCase(scheduleInfo[2])) {

                    String destination = scheduleInfo[0] + " - " + scheduleInfo[1];
                    destinationlbl.setText(destination);

                    datelbl.setText("  " + scheduleInfo[2]);
                    timelbl.setText("  " + scheduleInfo[3]);
                    seatlbl.setText("  " + scheduleInfo[4]);
                    price.setText("  " + scheduleInfo[5]);
                    break;
                }
            }

            purchasePn.toFront();
            purchaseStk.toFront();
        }

    }

    @FXML
    void onDatePickerClick(ActionEvent event) {
        LocalDate myDate = date.getValue();
        System.out.println("FROM: " + addressFrom.getText());
        System.out.println("TO: " + addressTo.getText());
        System.out.println("DATE: " + myDate);

    }

    @FXML
    void onClickPurchaseTicket(ActionEvent event) throws IOException {

        int seatCount = Integer.parseInt(seatfld.getText());
        int ticketPrice = Integer.parseInt(scheduleInfo[5]);
        int remainingTicket = Integer.parseInt(scheduleInfo[4])-seatCount;

        totalCost = ticketPrice * seatCount;
        System.out.println("YOUR COST: " + totalCost);
        StringBuilder updateInfo = new StringBuilder();
        StringBuilder finalReceipt = new StringBuilder();

        finalReceipt.append("Start: ").append(scheduleInfo[0]);
        finalReceipt.append("\nDestination: ").append(scheduleInfo[1]);
        finalReceipt.append("\nDate: ").append(scheduleInfo[2]);
        finalReceipt.append("\nTime: ").append(scheduleInfo[3]);
        finalReceipt.append("\nSeat: ").append(seatCount);

        for(int i=0; i<scheduleInfo.length; i++){
            if(i == scheduleInfo.length-1) updateInfo.append(scheduleInfo[i]);
            else if(i == scheduleInfo.length-2) updateInfo.append(remainingTicket).append(",");
            else updateInfo.append(scheduleInfo[i]).append(",");
        }

        System.out.println(updateInfo);
        this.setVariable(updateInfo.toString());

        totalBilllbl.setText(String.valueOf(totalCost));
        billDetailslbl.setText(finalReceipt.toString());
        finalMsgPn.toFront();
        finalMsgStk.toFront();
    }

    public void setVariable(String data) throws IOException {
        // index issue
        Path path = Paths.get("reservation.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(this.lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }



    // always remember ... we'll create a new client of newly created window
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }


}
