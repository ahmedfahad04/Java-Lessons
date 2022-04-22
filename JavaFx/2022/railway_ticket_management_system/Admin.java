package railway_ticket_management_system;

import java.util.Random;

public class Admin {

    // this whole class can be converted to an Abstract class....this will be done at the end of the project
    private int adminID;
    private String Name;
    private String Email;
    private String Phone;
    private Random createRandomId = new Random();

    public Admin(String adminEmail, String adminPhoneNumber, String adminName){

        this.Email = adminEmail;
        this.Phone = adminPhoneNumber;
        this.Name = adminName;

    }

    public void Registration(){
        this.adminID = createRandomId.nextInt(100000); // will use this token number to get logged into admin account

    }

    public void updateUserAccount() {

    }

    public void deleteUserAccount() {

    }

    public void Login() {   // need to be merged in an interface

    }

    public void updateTrainSchedule() {

    }


}
