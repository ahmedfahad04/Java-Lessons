package Main;

import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Objects;

import static Main.FXMLManager.LoadFXML;

public class Customer {

    // will consider how can we use private
    public int customerID;
    public String Phone;
    public String Email;
    public String Name;

    public Customer() {

    }

    public Customer(String customerEmail, String customerPhoneNumber, String customerName){

        this.Email = customerEmail;
        this.Phone = customerPhoneNumber;
        this.Name = customerName;

    }

    public void Register(int Token) throws IOException {  // this method need to be inherited as an abstract class

        this.customerID = Token; // will use this token number to get logged into user account
        String content = this.Name + "," + this.Phone + "," + this.Email + "," + customerID + "\n";

        System.out.println("Writing!!");
        FileWriter fw = new FileWriter("users.csv", true);
        fw.write(content);
        fw.close();
        System.out.println("DONE!!");
    }

    public void Login(String name, String password, MouseEvent actionEvent) throws IOException {

        FileReader fr;
        BufferedReader br;

        fr = new FileReader("users.csv");

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
            // System.out.println("WILL ENTER INTO NEW WINDOW");
            LoadFXML(actionEvent.getSource(), "/Main/newTicketBooking.fxml"); // this will be changed
        }

    }

    public void ticketBooking() {
        // multithreaded socket will be invoked while performing this task
    }

    public void updateAccountInfo() {

    }

    @Override
    public String toString() {
        return "Customer --" +
                "\nToken = " + customerID +
                "\nPhone = " + Phone +
                "\nEmail = " + Email +
                "\nName = " + Name;
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("abc@gmail.com", "01766610087", "Fahad");
        System.out.println(c1);
    }
}
