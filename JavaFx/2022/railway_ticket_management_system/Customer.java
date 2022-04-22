package railway_ticket_management_system;

import java.util.Random;

public class Customer {

    private int customerID;
    private String Phone;
    private String Email;
    private String Name;

    private Random createRandomId = new Random();

    public Customer(String customerEmail, String customerPhoneNumber, String customerName){

        this.Email = customerEmail;
        this.Phone = customerPhoneNumber;
        this.Name = customerName;

    }

    public void Registration(){
        this.customerID = createRandomId.nextInt(100000); // will use this token number to get logged into user account

    }

    public void Login() {

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
