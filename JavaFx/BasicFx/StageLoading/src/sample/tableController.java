package sample;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class tableController implements Initializable {

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

    @FXML
    private Button btnload;

    @FXML
    void clicktoreload(MouseEvent event) {
//
//        col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        col_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
//        col_icu.setCellValueFactory(new PropertyValueFactory<>("ICU"));
//        col_oxygen.setCellValueFactory(new PropertyValueFactory<>("Oxygen"));
//        col_contact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
//
//        tableInfo.setItems(formController.dataList); // adding to tableview

//        FilteredList<Hospital> filteredData = new FilteredList<>(formController.dataList, b -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(hospital -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (hospital.getName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (hospital.getAddress().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
//
//                else if (String.valueOf(hospital.getICU()).contains(lowerCaseFilter)) {
//                    return true;
//                }
//
//                else if (hospital.getOxygen().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
//
//                else if (hospital.getContact().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
//                else
//                    return false; // Does not match.
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList.
//        SortedList<Hospital> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tableInfo.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tableInfo.setItems(sortedData);
    }

    @FXML
    void clicktoreturn(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("form.fxml")));

        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow()); // delete current stage and show the other.
        stage.setScene(new Scene(pane));
        stage.setTitle("FormView");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File f = new File("data.csv");
        if(!f.exists()){
            try {
                f.createNewFile();
                System.out.println("New file created successfully!!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        formController.dataList.clear();

        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                String str = sc.nextLine();
                String[] parts = str.split(",");
                Hospital hp = new Hospital(parts[0],parts[1],parts[2],parts[3],parts[4]);
                formController.dataList.add(hp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        col_icu.setCellValueFactory(new PropertyValueFactory<>("ICU"));
        col_oxygen.setCellValueFactory(new PropertyValueFactory<>("Oxygen"));
        col_contact.setCellValueFactory(new PropertyValueFactory<>("Contact"));

        tableInfo.setItems(formController.dataList); // adding to tableview


        FilteredList<Hospital> filteredData = new FilteredList<>(formController.dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(hospital -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (hospital.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (hospital.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }

                else if (String.valueOf(hospital.getICU()).contains(lowerCaseFilter)) {
                    return true;
                }

                else if (hospital.getOxygen().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }

                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Hospital> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableInfo.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableInfo.setItems(sortedData);

    }

}
