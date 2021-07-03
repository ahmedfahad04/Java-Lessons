package sample;

import java.io.Serializable;

public class Hospital implements Serializable {
    private String Name;
    private String Address;
    private String ICU;
    private String Oxygen;
    private String Contact;

    public Hospital(String name, String address, String ICU, String oxygen, String contact) {
        Name = name;
        Address = address;
        this.ICU = ICU;
        Oxygen = oxygen;
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getICU() {
        return ICU;
    }

    public String getOxygen() {
        return Oxygen;
    }

    public String getContact() {
        return Contact;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setICU(String ICU) {
        this.ICU = ICU;
    }

    public void setOxygen(String oxygen) {
        Oxygen = oxygen;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", ICU='" + ICU + '\'' +
                ", Oxygen='" + Oxygen + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }
}
