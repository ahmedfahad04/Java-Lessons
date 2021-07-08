package com.concepts;

class CellPhone{
    String color = "Black";
    boolean flashLight = true;
    boolean speaker = true;

    public void vibrate(){
        System.out.println("Phone is vibrating");
    }

    public void playRadio(){
        System.out.println("Radio is playing");
    }

    public void setAlarm(){
        System.out.println("Set your alarm here...");
    }

    public void calculator(){
        System.out.println("You can calculate and convert some units");
    }

}

interface GPS{
    String gpsModel = "12F51-D";
    void showGPS();
    void navigateUser();
}

interface Camera{
    void openCamera();
    void clickImage();
}

interface MusicPlayer{
    void showPlayer();
    void playMusic();
}

interface Wifi{
    String[] getNetworks();
    void connectToNetwork(String network);

    //default methods
    /*
    basically after implementing methods of a class
    if we need to add more methods it will show error and also
    force the class(that implemented this interface) to write the
    method body.

    But we can skip this situation by making the new method "DEFAULT"
    we can make default method like below. The additional facility is
    we can also override the method in the class that inherit wifi interface.
    we can also use PRIVATE methods in interface
     */

    default void searchingMoreNetworks(){
        System.out.println("Wifi is searching new networks");
    }
}

// this is a smartphone which is actually a cellphone and also acts as gps, camera..etc.
// this is polymorphism in inheritance
class SmartPhone extends CellPhone implements GPS, Camera, MusicPlayer, Wifi{
    String gpsModel = "DD15"; //but you can override the fields. not recommended

    @Override
    public void showGPS() {
        System.out.println("Smart Phone GPS loading....");
    }

    @Override
    public void searchingMoreNetworks() {
        System.out.println("This method is also overridden. It shows that a default method can also" +
                "be overridden");
    }

    @Override
    public void navigateUser() {
        System.out.println("Now I am in Bangladesh");
    }

    @Override
    public void openCamera() {
        System.out.println("Opening Camera");
    }

    @Override
    public void clickImage() {
        System.out.println("Press the red button to capture image");
    }

    @Override
    public void showPlayer() {
        System.out.println("Music player ready to go...");
    }

    @Override
    public void playMusic() {
        System.out.println("'Allah Allah ..' is playing");
    }

    public String[] getNetworks(){
        System.out.println("Getting List of Networks");
        String[] networkList = {"Fahad", "Rajin", "Kalam Vai"};
        return networkList;
    }
    public void connectToNetwork(String network){
        System.out.println("Connecting to " + network);
    }
}


public class Interface {
    public static void main(String[] args) {
        SmartPhone xiaomi = new SmartPhone();
        xiaomi.showGPS();
        xiaomi.playMusic();
        xiaomi.playRadio();
        xiaomi.searchingMoreNetworks();

        String[] networks = xiaomi.getNetworks();
        for(String net: networks) {
            xiaomi.connectToNetwork(net);
        }

        System.out.println("GPS model is: " + xiaomi.gpsModel); // this value is const. never be changed

        GPS gps1 = new SmartPhone();

//        It is not allowed . it means we are restricting the user to use the gps only, not other features of smartphone is allowed here.
//        gps1.getNetworks()
        gps1.showGPS();




        /*
         Note:
         - The thing is that the CELLPHONE class is now evolved to SMARTPHONE class.
         That means smartphones inherit all features of cellphone and more over it also
         have GPS, Camera, MusicPlayer which is not in cellPhone. So, in this way we can
         add the additional features as INTERFACE and get the General structure using
         INHERITANCE.

         - Interface can also be used to restrict specific users to use specific features of
         product. Like the gps1 obj above done.

         Thus we can relate interface with real world scenarios.

         # default methods (watch wifi interface)
         # private methods can also be added to the interface. Also
         can give the implementations of that private method.
         # If I take the reference of a class and make obj of its child class
         then the obj can ONLY access the method and fields of that REFERENCE class.
         like the gps1 obj above.

         */
    }
}
