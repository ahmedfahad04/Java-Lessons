package com.concepts;

class Car{
    public void start(){
        System.out.println("Starting the engine");
    }
}

class Corolla extends Car{
    @Override
    public void start(){
        System.out.println("Starting the engine of COROLLA");
    }

    public void ID(){
        System.out.println("My id is: 12541-D");
    }
}

class Audi extends Car{
    @Override
    public void start(){
        System.out.println("Starting the engine of AUDI");

    }
}

public class Dynamic_method_dispatching {
    public static void main(String[] args){
        Car mycar; //car reference - pointing to a car type object
        mycar = new Corolla(); // object of Corolla // also known as upcasting
        mycar.start();
//        mycar.ID(): its not valid as I am a pointer of CAR class
//        So I can only access the property of CAR(parent) class
//        none of the child class's method I can invoke.
//

        Corolla newCar = new Corolla();
        newCar.ID();
        newCar.start();

        String d = "25";
        float num;
        double num2;
        num2 = 120.25;
        // data type for primitive data
        System.out.println(((Object) num2).getClass().getSimpleName());
        // data type for non-primitive data
        System.out.println(d.getClass().getSimpleName());

        // note:
//        1. static method dispatching means Method () -> Overloading
//        2. dynamic method dispatching means Method() -> Overriding
//        3. while overriding a method you must maintain the return type and
//        argument type. You cant change both these. You can modify the
//        method body.
//        compile time vs run time:
//        https://prepinsta.com/wp-content/uploads/2020/05/Difference-between-CompileTime-vs-Runtime-Polymorphism-in-C-%E2%80%93-1-1024x682.png



    }
    
}
