package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller extends Features implements Initializable {

    @FXML
    private TableView<Hospital> table;
    @FXML
    private TableColumn<Hospital, String> colName;
    @FXML
    private TableColumn<Hospital, String> colLoc;
    @FXML
    private TableColumn<Hospital, String> colICU;
    @FXML
    private TableColumn<Hospital, String> colOxy;
    @FXML
    private TableColumn<Hospital, String> colContact;
    @FXML
    private TableColumn<Hospital, String> colUpdate;
    @FXML
    private TextField searchBar;

    @FXML
    private CheckBox chkICU;

    @FXML
    private CheckBox chkOxygen;

    @FXML
    private Button btnReload;



    ArrayList<TableColumn<Hospital, String>> AllColumns = new ArrayList<>();

    void fetchData(){
        AllColumns.add(colName);
        AllColumns.add(colLoc);
        AllColumns.add(colICU);
        AllColumns.add(colOxy);
        AllColumns.add(colContact);
        AllColumns.add(colUpdate);
    }

    @FXML
    void showChkResult() {
        boolean icu = chkICU.isSelected();
        boolean oxy = chkOxygen.isSelected();

        int filter = 2;

        if(!icu && oxy) filter =  0;
        else if(!oxy && icu) filter = 1;

        File f = ReadFile("data.csv");

        fetchData();
        
        TableManager(f, AllColumns,table, filter);

        SearchingContent(searchBar, table);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File f = ReadFile("data.csv");
        fetchData();
        TableManager(f, AllColumns,table, 2);

        SearchingContent(searchBar, table);
    }


}
