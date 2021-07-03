package com.practices;

class Cylinder{
    public float radius;
    public float height;

    public Cylinder(int r, int h){
        this.radius = r;
        this.height = h;
    }

    public Cylinder() {
        System.out.println("This is an empty constructor");
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double area(){
        return 3.1416*radius*radius*height;
    }

    public double surfaceArea(){
        return 2*3.1416*radius*(radius+height);
    }
}

class Rectangle{
    private float length;
    private float width;

    public Rectangle(int x){
        this.length = x;
        this.width = 5;
    }

    @Override
    public String toString() {
        return "rectangle:-\n" +
                "length=" + getLength() + "\n" +
                "width=" + getWidth() + "\n" ;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}

public class practiceSet8 {
    public static void main(String[] args) {
        // Question 1
        Cylinder c = new Cylinder();
        c.setRadius(5);
        c.setHeight(10);

        // Question 2
        System.out.println("Area of cylinder: " + c.area());
        System.out.println("Volume fo Cylinder: " + c.surfaceArea());

        // Question 3
        Cylinder c2 = new Cylinder(10,5);
        System.out.println("Area of cylinder: " + c2.area());
        System.out.println("Volume fo Cylinder: " + c2.surfaceArea());

        // Question 4
        Rectangle r = new Rectangle(5);
        System.out.println(r);

        // Question 5
        // do the same as question 1 for SPHERE.


    }
}
