/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableviewaddrows;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Cool IT Help
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Employee> tableview;
    @FXML private TableColumn<Employee, String> EmpID;
    @FXML private TableColumn<Employee, String> empName;
    @FXML private TableColumn<Employee, String> empEmail;
    @FXML private TableColumn<Employee, String> department;
    @FXML private TableColumn<Employee, String> salary;
    
   
                  
    //observalble list to store data
    private final ObservableList<Employee> dataList = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
                               
        EmpID.setCellValueFactory(new PropertyValueFactory<>("EmpID"));       
        empName.setCellValueFactory(new PropertyValueFactory<>("firstName"));        
        empEmail.setCellValueFactory(new PropertyValueFactory<>("email"));        
        department.setCellValueFactory(new PropertyValueFactory<>("department"));        
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));       
        
        
        Employee emp1 = new Employee(112, "AMIT", "ams@gmail.com", "Finance", 30000);
        Employee emp2 = new Employee( 115, "Peter", "peter@gmail.com", "Defence System", 40000);
        Employee emp3 = new Employee( 116, "SAM", "sam@gmail.com", "Radar Anaysist", 80000);
        Employee emp4 = new Employee(117, "Jhon", "jhon@gmail.com", "Ground Staff", 80000);                   
           
        dataList.addAll(emp1,emp2, emp3, emp4);
        
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Employee> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (employee.getDepartment().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(employee.getSalary()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Employee> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableview.setItems(sortedData);
               
        
    }    
    
}
