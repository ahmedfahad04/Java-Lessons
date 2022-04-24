package Reservation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;


public class AddNewEntryController implements Initializable {

    @FXML
    private StackPane addFieldStk;

    @FXML
    private AnchorPane addFieldPn;

    @FXML
    private Button addNewFieldBtn;

    @FXML
    private DatePicker datefld;

    @FXML
    private TextField setSeatfld;

    @FXML
    private TextField pricefld;

    @FXML
    private ComboBox<String> fromCombo;

    @FXML
    private ComboBox<String> toCombo;

    @FXML
    private ComboBox<String> timeCombo;

    @FXML
    private ComboBox<String> trainCombo;

    String startingLocation;
    String destination;
    String time;
    String date;
    String train;
    int seat, price;

    @FXML
    void onClickAddNewField(ActionEvent event) throws IOException {

        startingLocation = fromCombo.getValue();
        destination = toCombo.getValue();
        time = timeCombo.getValue();
        seat = Integer.parseInt(setSeatfld.getText());
        price = Integer.parseInt(pricefld.getText());
        date = String.valueOf(LocalDate.parse(String.valueOf(datefld.getValue())));
        train = trainCombo.getValue();

        String content = startingLocation + "," + destination + "," + date + "," + time + "," + seat + "," + price + "," + train + "\n";

        FileWriter fw = new FileWriter("reservation.csv", true);
        fw.write(content);
        fw.close();

    }

    @FXML
    void onDatePickerClick(ActionEvent event) {

    }

    public void addComboBoxItem() throws IOException {

        FileReader fr, fr2;
        BufferedReader br, br2;
        String line;

        fr = new FileReader("stationList.txt");
        fr2 = new FileReader("trainList.txt");
        br = new BufferedReader(fr);
        br2 = new BufferedReader(fr2);
        ObservableList<String> stationList, TimeList, trainList;
        stationList = FXCollections.observableArrayList();
        trainList = FXCollections.observableArrayList();

        while ((line = br.readLine()) != null) { // read a line
            if(line.length() > 0){
                stationList.add(line);
                FXCollections.sort(stationList);
            }
        }

        fromCombo.setItems(stationList);
        toCombo.setItems(stationList);

        TimeList = FXCollections.observableArrayList("6:15","7:00","8:00");
        timeCombo.setItems(TimeList);

        while((line = br2.readLine()) != null) {
            if(line.length()>0){
                trainList.add(line);
                FXCollections.sort(trainList);
            }
        }

        trainCombo.setItems(trainList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addComboBoxItem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
