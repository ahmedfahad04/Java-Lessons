package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class formController {

    @FXML
    private Pane tableCont;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txticu;

    @FXML
    private TextField txtoxygen;

    @FXML
    private TextField txtcontact;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnshow;

    static ObservableList<Hospital> dataList = FXCollections.observableArrayList();

    @FXML
    void clicktoAdd(MouseEvent event) {
        String Name = txtname.getText();
        String Address = txtaddress.getText();
        String ICU = txticu.getText();
        String Oxygen_capacity = txtoxygen.getText();
        String Contact = txtcontact.getText();

        Hospital h1 = new Hospital(Name, Address, ICU, Oxygen_capacity, Contact);

        // save info as csv file.

        File f = new File("data.csv");
        if(!f.exists()){
            try {
                f.createNewFile();
                System.out.println("New file created successfully!!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(f,true);
            System.out.println("Info Added successfully");
            fw.write(Name + "," + Address + "," + ICU + ", " + Oxygen_capacity + "," + Contact + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataList.add(h1);

        txtname.clear();
        txtaddress.clear();
        txticu.clear();
        txtoxygen.clear();
        txtcontact.clear();
    }

    @FXML
    void clicktoShow(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("table.fxml")));

        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(new Scene(pane));
        stage.setTitle("FormView");
        stage.show();
    }

}
