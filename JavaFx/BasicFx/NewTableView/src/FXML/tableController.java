package FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Hospital;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class tableController implements Initializable {

    public Button btnload;
    @FXML
    private TableView<Hospital> tableInfo;

    @FXML
    private TableColumn<Hospital, String> col_name;

    @FXML
    private TableColumn<Hospital, String> col_address;

    @FXML
    private TableColumn<Hospital, String> col_icu;

    @FXML
    private TableColumn<Hospital, String> col_oxygen;

    @FXML
    private TableColumn<Hospital, String> col_contact;


    @FXML
    private TextField txtsearch;

    @FXML
    private Button btnok;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void clicktoreturn(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("src/FXML/form.fxml")));
        Scene sc = new Scene(node);
        Stage st = new Stage();
        st.setScene(sc);
        st.setTitle("Form");
        st.show();
    }


    public void clicktoreload(MouseEvent mouseEvent) {
        Hospital[] hp;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/BinFile/hospital.bin"));
            hp = (Hospital[]) is.readObject();
            is.close();

            for(Hospital x: hp){
                System.out.println(x);
                Hospital hosp = new Hospital(x.getName(), x.getAddress(), x.getICU(), x.getOxygen(), x.getContact());
                formController.dataList.add(hosp);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        col_name.setCellValueFactory(new PropertyValueFactory<Hospital, String>("name"));
        col_address.setCellValueFactory(new PropertyValueFactory<Hospital, String>("address"));
        col_icu.setCellValueFactory(new PropertyValueFactory<Hospital, String>("icu"));
        col_oxygen.setCellValueFactory(new PropertyValueFactory<Hospital, String>("oxygen"));
        col_contact.setCellValueFactory(new PropertyValueFactory<Hospital, String>("contact"));

        tableInfo.setItems(formController.dataList); // adding to tableview

    }
}
