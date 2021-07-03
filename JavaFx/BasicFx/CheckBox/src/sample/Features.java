package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Features {
    ObservableList<Hospital> dataList = FXCollections.observableArrayList();

    public void TableManager(File fp, ArrayList<TableColumn<Hospital, String>> x, TableView tb, int filter) {
        dataList.clear();
        try {
            Scanner sc = new Scanner(fp);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] parts = str.split(",");
                Hospital hp = null;
                int icu = Integer.parseInt(parts[2]);
                int oxygen = Integer.parseInt(parts[3]);

                if(filter == 1){

                    if(icu!=0){
                        System.out.println("ICU:" + icu);
                        hp = new Hospital(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    }
                    if(hp!= null) dataList.add(hp);

                }
                else if(filter == 0){

                    if(oxygen!=0){
                        System.out.println("OX: "+oxygen);
                        hp = new Hospital(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    }
                    if(hp!= null) dataList.add(hp);
                }
                else{
                    System.out.println("OTHERS: ");
                    hp = new Hospital(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    dataList.add(hp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        x.get(0).setCellValueFactory(new PropertyValueFactory<>("Name"));
        x.get(1).setCellValueFactory(new PropertyValueFactory<>("Address"));
        x.get(2).setCellValueFactory(new PropertyValueFactory<>("ICU"));
        x.get(3).setCellValueFactory(new PropertyValueFactory<>("Oxygen"));
        x.get(4).setCellValueFactory(new PropertyValueFactory<>("Contact"));
        x.get(5).setCellValueFactory(new PropertyValueFactory<>("UpdateTime"));

        tb.setItems(dataList); // adding to tableview
    }


    public File ReadFile(String fileName) {

        File f = new File(fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("New file created successfully!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
    }


    public void WriteFile(File fp, String content, boolean append) throws IOException {

        FileWriter fw = new FileWriter(fp, append);
        fw.write(content);
        fw.close();
    }

    public void SearchingContent(TextField tf, TableView tb) {
        FilteredList<Hospital> filteredData = new FilteredList<>(dataList, b -> true);

        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(hospital -> {

                if (newValue == null || newValue.isEmpty() || hospital == null) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(!hospital.getName().equals("") && !hospital.getAddress().equals("") &&!hospital.getICU().equals("") && !hospital.getOxygen().equals("") ){
                    if (hospital.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (hospital.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (String.valueOf(hospital.getICU()).contains(lowerCaseFilter)) {
                        return true;
                    } else return hospital.getOxygen().toLowerCase().contains(lowerCaseFilter);
                }
                else return true;

            });
        });

        SortedList<Hospital> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tb.comparatorProperty());
        tb.setItems(sortedData);
    }

}
