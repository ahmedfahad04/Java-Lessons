package Mobile_Banking;
import java.lang.String;

public class Banking{

    private String account_holder_name;
    private String account_phone_number;
    private double balance = 10000;
    private String pin;

    public Banking(String name,String account_phone_number,String pin){
        this.account_holder_name=name;
        this.account_phone_number=account_phone_number;
        this.pin=pin;
    }

    public Banking(String name, String account_phone_number){
        this.account_holder_name=name;
        this.account_phone_number=account_phone_number;
        this.pin="\0";
    }


    public boolean pin_update(String old_pin, String new_pin) {

        if (this.pin == "\0") {
            this.pin = new_pin;
            System.out.println("New pin initialized! " + pin_print());
            return true;
        } else if (old_pin == this.pin) {
            this.pin = new_pin;
            System.out.println("Pin updated! " + pin_print());
            return true;
        } else {
            System.out.println("Old pin doesnt match " + pin_print());
            return false;
        }

    }

    private String pin_print(){
        String new_pin_info = getAccount_holder_name()+ "Pin: " +this.pin;
        return new_pin_info;
    }

    public void add_money(double amount, int balance){
        this.balance += amount;
        System.out.println("Add money: " + amount + " "+ account_holder_name);
    }

//    public void add_money(double amount, double balance){
//
//    }


    public void cash_out(double amount,String pin){

        if(pin!=this.pin){
            System.out.println("Pin doesn't match or is not updated!");}

        else if(pin==this.pin && pin=="\0"){
            System.out.println("Pin not initialized");
        }
        else{
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Cash out: " + amount + account_holder_name);
            } else {
                System.out.println("Failed to cash out due to balance limit");
            }
        }
    }

    public String getAccount_holder_name(){
        return this.account_holder_name;
    }

    protected String getAccount_phone_number(){
        return this.account_phone_number;
    }

    public double getBalance(){
        return this.balance;
    }

}


