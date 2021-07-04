package com.practices;

class Circle{
    double radius;

    public Circle(){
        System.out.println("This is the Class Circle");
    }

    public void area(){
        System.out.println("Circle area: " + 3.1416*radius*radius);
    }

    public void volume(){
        System.out.println("Circle does have any volume");
    }

}

class Spehere extends Circle{
    double rad;

    public Spehere(double r){
        rad = r;
    }

    public Spehere(){
        System.out.println("This is the Class Spehere extended from Circle");
    }

    @Override
    public void area(){
        System.out.println("Sphere Area: " + 3.1416*rad*rad*4);
    }

    @Override
    public void volume(){
        System.out.println("Sphere Volume: "+(4/3.0)*3.1416*rad*rad*rad);
    }

}

class rectangle{
    double x;
    double y=1;

//    public rectangle(double side){
//        x = side;
//    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public rectangle(double xx){
        System.out.println("This is the Rectangle Class");
        this.x = xx;
    }


    public void area(){
        System.out.println("Rectangle area: " + x*y);
    }

    public void volume(){
        System.out.println("Rectangle does have any volume");
    }
    
    public void rect_side(){
        System.out.println("Inside rectangle class " + x);
    }
}

class Cuboid extends rectangle{

    public Cuboid(double x){
        super(x);
        this.x = x;
        System.out.println("This is the cuboid class");
    }


    @Override
    public void area(){
        System.out.println("Cuboid Area: " + 6*x*x);
    }

    @Override
    public void volume(){
        System.out.println("Cuboid Volume: "+ x*x*x);
    }
}

public class practiceSet9 {

    public static void main(String[] args) {
//        //Question 1
//        Spehere sp = new Spehere();
//        System.out.println(sp);
//
//        //Question 2
//        rectangle obj = new Cuboid();
//        System.out.println(obj);

        //Question 3
        Circle c = new Spehere(2.5);
        c.area();
        c.volume();

        //Question 4
        rectangle cube = new rectangle(5);
        cube.rect_side();

    }
}
