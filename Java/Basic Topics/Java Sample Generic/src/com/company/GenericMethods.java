package com.company;

public class GenericMethods {

    public static <E> void printElement(E[] list){
        for(E a: list){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Integer[] roll = {10, 14, 15, 1, 99, 47};   // you can't declare int (primitive data types), it should be Integer
        Double[] price = {14.5, 57.6, 9.4, 447.1};
        String[] names = {"Fahad", "Ahmed", "Saad", "Galib"};
        printElement(names);
        printElement(roll);
        printElement(price);
    }
}
