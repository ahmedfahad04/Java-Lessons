package com.practices;

abstract class pen{
    abstract void write();
    abstract void refill();
}

class fountainPen extends pen{
    public void changeNib() {
        System.out.println("Change the pen's Nib.");
    }

    @Override
    void write() {
        System.out.println("Writing with fountain pen");
    }

    @Override
    void refill() {
        System.out.println("Low ink!! Please refill the pen to continue your writing");
    }
}

interface TVremote{

}

interface SmartTVremote extends TVremote{

}

class TV implements TVremote{

}

public class practiceSet10 {
    public static void main(String[] args) {
        // Question 1
        // Create an abstract class pen with methods write () and refill () as abstract methods

        // Question 2
        // Use the pen class from Q1 to create a concrete class fountain pen with additional
        // method change Nib ()

        // Question 3
        // Create a class monkey with jump ( ) and bite ( ) methods Create a class human
        // which inherits this monkey class and implements basic animal interface with eat
        // ( ) and sleep methods ... do by yourself.

        // Question 4
        // Create a class telephone with ( ) , lift ( ) and disconnected ( ) methods
        // as abstract methods create another class smart telephone and demonstrate polymorphism
        // same as Q1

        // Question 6
        // Create an interface TVremote and use it to inherit another interface smart TVremote

        // Questino 7
        // Create a class TV which implements TVremote interface from Q6


    }
}
