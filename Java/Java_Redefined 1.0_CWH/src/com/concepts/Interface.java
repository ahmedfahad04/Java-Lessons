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

class SmartPhone extends CellPhone implements GPS, Camera, MusicPlayer{

    @Override
    public void showGPS() {
        System.out.println("Smart Phone GPS loading....");
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
        System.out.println("Music palyer ready to go...");
    }

    @Override
    public void playMusic() {
        System.out.println("'Allahu Allahu ..' is playing");
    }
}


public class Interface {
    public static void main(String[] args) {
        SmartPhone xiaomi = new SmartPhone();
        xiaomi.showGPS();
        xiaomi.playMusic();
        xiaomi.playRadio();

        /*
         Note:
         The thing is that the CELLPHONE class is now evolved to SMARTPHONE class.
         That means smartphones inherit all features of cellphone and more over it also
         have GPS, Camera, MusicPlayer which is not in cellPhone. So, in this way we can
         add the additional features as INTERFACE and get the General structure using
         INHERITANCE.

         Thus we can relate interface with real world scenarios.
         */
    }
}
