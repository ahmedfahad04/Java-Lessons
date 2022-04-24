package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class newTicketBookingController extends Thread implements Initializable {


    @FXML
    private StackPane finalMsgStk;

    @FXML
    private AnchorPane finalMsgPn;

    @FXML
    private Button returnToBookingPage2;

    @FXML
    private Label billDetailslbl;

    @FXML
    private Label totalBilllbl;

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
    private TextField seatfld;

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
    private Button findTicketBtn;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> addressFrom;

    @FXML
    private ComboBox<String> addressTo;


    DataInputStream reader;
    DataOutputStream writer;
    Socket socket;
    static Customer user;
    int totalCost;
    String[] scheduleInfo;
    String oldline;


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
//        addressTo.setText("");
//        addressFrom.setText("");

        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }

    @FXML
    public void onFindTicketBtnClick(ActionEvent event) throws IOException {

        String from = addressFrom.getValue();
        String to = addressTo.getValue();
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
                scheduleInfo = line.split(",");

                if (from.equalsIgnoreCase(scheduleInfo[0]) && to.equalsIgnoreCase(scheduleInfo[1]) && fromattedDate.equalsIgnoreCase(scheduleInfo[2])) {

                    oldline = line;
                    destinationlbl.setText("\t" + scheduleInfo[6]);

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
        System.out.println("FROM: " + addressFrom.getValue());
        System.out.println("TO: " + addressTo.getValue());
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

        // making array of new value
        finalReceipt.append("Train: ").append(scheduleInfo[6]);
        finalReceipt.append("\nStart: ").append(scheduleInfo[0]);
        finalReceipt.append("\nDestination: ").append(scheduleInfo[1]);
        finalReceipt.append("\nDate: ").append(scheduleInfo[2]);
        finalReceipt.append("\nDeparture: ").append(scheduleInfo[3]);
        finalReceipt.append("\nBooked Seat: ").append(seatCount);

        for(int i=0; i<scheduleInfo.length; i++){
            if(i == scheduleInfo.length-1) updateInfo.append(scheduleInfo[i]);
            else if(i == scheduleInfo.length-3) updateInfo.append(remainingTicket).append(",");
            else updateInfo.append(scheduleInfo[i]).append(",");
        }

        System.out.println(updateInfo);
        overWriteFile(oldline, updateInfo.toString());

        totalBilllbl.setText(String.valueOf(totalCost));
        billDetailslbl.setText(finalReceipt.toString());
        finalMsgPn.toFront();
        finalMsgStk.toFront();
    }

    public void overWriteFile(String oldLine, String newLine) throws IOException {

        Path path = Paths.get("reservation.csv");
        Scanner sc = new Scanner(new File(String.valueOf(path)));
        StringBuilder buffer = new StringBuilder();

        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()).append(System.lineSeparator());
        }

        String fileContents = buffer.toString();
        //System.out.println("Contents of the file: "+fileContents);
        sc.close();

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);

        FileWriter writer = new FileWriter(String.valueOf(path));
        //System.out.println("");
        //System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }

    public void addComboBoxItem() throws IOException {

        FileReader fr;
        BufferedReader br;
        String line;
        fr = new FileReader("reservation.csv");
        br = new BufferedReader(fr);

        ObservableList<String> startingStationList, destinationList;
        startingStationList = FXCollections.observableArrayList();
        destinationList = FXCollections.observableArrayList();

        while ((line = br.readLine()) != null) { // read a line
            if(line.length() > 0){
                String[] items = line.split(",");
                startingStationList.add(items[0]);
                destinationList.add(items[1]);
                FXCollections.sort(startingStationList);
                FXCollections.sort(destinationList);
            }
        }

        addressFrom.setItems(startingStationList);
        addressTo.setItems(destinationList);

    }


    // always remember ... we'll create a new client of newly created window
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addComboBoxItem();
        } catch (IOException e) {
            e.printStackTrace();
        }

        regPn.toFront();
        registerStk.toFront();
        connectSocket();
    }


}
