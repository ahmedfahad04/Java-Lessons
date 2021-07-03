/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableviewaddrows;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Cool IT help
 */
public class Employee {    
    private  final SimpleIntegerProperty EmpID;
    private  final SimpleStringProperty firstName;
    private  final SimpleStringProperty email;
    private  final SimpleStringProperty department;
    private  final SimpleIntegerProperty salary;
    
    Employee(Integer id, String firstname, String mail, String department, Integer salary)
    {      
       this.EmpID = new SimpleIntegerProperty(id);
       this.firstName = new SimpleStringProperty(firstname);
       this.email =  new SimpleStringProperty(mail);
       this.department =  new SimpleStringProperty(department);
       this.salary =  new SimpleIntegerProperty(salary);
    
    }
    
     
    public int getEmpID() {
        return EmpID.get();
    }

    public void setEmpID(int id) {
        this.EmpID.set(id);
    }
    
   
  
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstname) {
        firstName.set(firstname);
    }
    
    

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String mail) {
        email.set(mail);
    }
    
    
    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String street) {
        this.department.set(street);
    }
    
   

    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }
    
    
}
    
