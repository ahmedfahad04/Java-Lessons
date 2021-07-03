package FXML;

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
import sample.Hospital;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class formController {

    public Button btnshow;
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

    static ObservableList<Hospital> dataList = FXCollections.observableArrayList();

    @FXML
    void clicktoAdd(MouseEvent event) {
        String Name = txtname.getText();
        String Address = txtaddress.getText();
        String ICU = txticu.getText();
        String Oxygen_capacity = txtoxygen.getText();
        String Contact = txtcontact.getText();

        Hospital h1 = new Hospital(Name, Address, ICU, Oxygen_capacity, Contact);


        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/BinFile/hospital.bin"));// give the right path.
            os.writeObject(h1);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataList.add(h1);
        System.out.println("Info Added Successfully!");

        txtname.clear();
        txtaddress.clear();
        txticu.clear();
        txtoxygen.clear();
        txtcontact.clear();

    }

    @FXML
    void clicktoShow(ActionEvent event) throws IOException {

        Stage st = (Stage)(((Node)event.getSource()).getScene().getWindow());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("table.fxml"));
            Parent root = fxmlLoader.load();
            Scene sc = new Scene(root);
            st.setScene(sc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
