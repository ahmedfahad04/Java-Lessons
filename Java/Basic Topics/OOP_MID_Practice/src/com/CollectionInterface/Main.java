package com.CollectionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        String[] colors = new String[] {"RED", "GREEN", "BLUE"};
        
        ArrayList<String> colorlist = new ArrayList<String>(Arrays.asList(colors));
        List <String> ls = Arrays.asList(colors);

        ArrayList<String> dept = new ArrayList<>();

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("You've entered: " + n);

        for(int i=0; i<n; i++){
            String name = sc.next();
            dept.add(name);
        }

        for(String name: dept){
            System.out.println("DEPT: " + name);
        }

        for(String color: ls){
            System.out.println(color);
        }
    }
}
