package com.concepts;


abstract class bsse{
    abstract public void run();
}

abstract class fahad extends bsse{
    abstract public void run();
}

class sakib extends fahad{
    @Override
    public void run() {
        System.out.println("Its Sakib's IIT");
    }
}

public class AbstractClass {
    public static void main(String[] args) {


        //Abstract Class usage

      fahad f = new sakib(); // --error if I don't use fahad as a parent class
//      bsse f2 = new bsse(); -// --error

        sakib f4 =  new sakib();
        bsse f3 = new sakib();
        f.run();
        f3.run();
        f4.run();




/*
        Note:(Abstract class)
        1. abstract class can be used only as "REFERENCE". No object instantiation is allowed.
        2. Child class of abstract classes can be "instantiate"
        3. child class of abstract class is called "Concrete" class

        ## When to use Abstract class:
        When we know that all the animal child classes will and should override this method,
        then there is no point to implement this method in parent class. Thus, making this method
        abstract would be the good choice as by making this method abstract we force all the sub
        classes to implement this method( otherwise you will get compilation error), also we need
        not to give any implementation to this method in parent class.

        resource: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

        Note:(Interface)
        1. while implementing interfaces methods I must declare "public" keyword
        2. benefit is that I can implement "multiple" interface to a class and also
        can extends one other class.
        3. can create properties("variable") in interface but can't MODIFY.

        ## When to use Interface:
        Same as the abstract class. Difference is it can be achieved 100%abstraction using
        interface and also we can implement more than "one" interface at a time which is not
        possible in abstract class. It mainly used to implementing common features of
        objects.

        [Think of a Music Player. It has specific GUI-Graphical User Interface. Here this interface
        means it holds some properties like play, pause and resume buttons, playlist window, song list
        artist list and so on. So it means certain pane or window(mainly interface) has certain types of
        properties and using a interface class we can define the signature of these types of properties
        and their child class will implement these methods.]

        resource: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
*/












    }
}
