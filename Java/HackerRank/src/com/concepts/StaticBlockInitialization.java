package com.concepts;

class StaticVar{
    public int age = 15; // this is called INSTANCE VARIABLE
    public static String name = "Fahad"; // this is called CLASS VARIABLE
    public static String run(){
        return "he is running in the field";
    }
}

public class StaticBlockInitialization {

    static boolean flag;
    static {
        if(flag==false){
            System.out.println("Yes. This is alright");
        }
        else{
            System.out.println("Not right at all");
            System.out.println("Because, util I put this if-else ladder inside a static block" +
                    "it won't work. It will show error");
        }
    }

    static {
        System.out.println("Multiple static block is allowed");
    }


    public static void main(String[] args) {
        StaticVar s = new StaticVar();

        System.out.println("Age: " + s.age); //obj is a must
        System.out.println("Name: " + StaticVar.name); //only reference
        System.out.println("Static method says: " + StaticVar.run()); //only reference
        System.out.println("is it flag? " + flag);


        /*
        Note:
        While using the static keyword before any variable of a class we just need to
        REFERENCE to access the static variable. NO NEED TO MAKE ANY OBJECT OF THAT CLASS.
        Reference is ENOUGH.

        resource: https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
         */


    }
}
