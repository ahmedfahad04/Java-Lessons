package Main;

import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Objects;
import java.util.Random;

import static Main.FXMLManager.LoadFXML;

public class Admin {

    // this whole class can be converted to an Abstract class....this will be done at the end of the project
    private int adminID;
    private String Name;
    private String Email;
    private String Phone;
    private Random createRandomId = new Random();

    public Admin() {

    }

    public Admin(String adminEmail, String adminPhoneNumber, String adminName){

        this.Email = adminEmail;
        this.Phone = adminPhoneNumber;
        this.Name = adminName;

    }

    public void Register(int token) throws IOException {

        this.adminID = token; // will use this token number to get logged into admin account
        String content = this.Name + "," + this.Phone + "," + this.Email + "," + adminID + "\n";

        System.out.println("Writing!!");
        FileWriter fw = new FileWriter("admins.csv", true);
        fw.write(content);
        fw.close();
    }

    public void updateUserAccount() {

    }

    public void deleteUserAccount() {

    }

    public void Login(String name, String password, MouseEvent event) throws IOException {   // need to be merged in an interface

        FileReader fr;
        BufferedReader br;
        fr = new FileReader("admins.csv");

        br = new BufferedReader(fr);
        String line;
        int flag = 0;

        while ((line = br.readLine()) != null) { // read a line
            String[] part = line.split(",");
            if (Objects.equals(part[3], password) && Objects.equals(part[0], name)) {
                System.out.println("Login Successful!!");
                flag = 1;
                break;
            }
        }

        if (flag == 0) System.out.println("Wrong Credentials! Try again.");
        else {
            LoadFXML(event.getSource(), "/Reservation/addField.fxml");
        }
    }

    public void updateTrainSchedule() {

    }


}
