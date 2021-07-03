package Mobile_Banking;

class Islami_Bank{
    public String acc_num = "20145589";
    public void transection(){
        System.out.println("Cash OUT: 500 tk");
    }
}

class inheritance_polymorphism extends Islami_Bank{
    public String name = "Fahad";

    @Override                   //polymorphism**(means access to edit the class attribs)
    public void transection() {     // you have the access to edit the inherited class methods
        System.out.println("Its using POLYMORPHISM"); // main game is on
    }

    public static void hello(){
        System.out.println("Hello Fahad");
    }

    public static void main(String[] args){

//        Bkash acc = new Bkash(); // this is our INHERITANCE** Example
//        acc.transection();
//        System.out.println(acc.name);

        inheritance_polymorphism cash = new inheritance_polymorphism(); // inheritance**
        cash.transection();
        cash.acc_num = "11111";
        System.out.println("Account Number: " + cash.acc_num);
        hello(); // using static i can call it without mentioning its object name(cash.hello())
    }
}
