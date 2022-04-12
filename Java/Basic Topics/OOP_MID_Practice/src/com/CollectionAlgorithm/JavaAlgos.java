package com.CollectionAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class JavaAlgos {
    public static void main(String[] args) {

        String[] institutes = new String[]{"IIT", "DU", "BUET", "BAU", "DMC", "IIT", "BUET"};
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();

        vector.add("WHITE");
        vector.add("GREEN");
        vector.add("BLUE");
        vector.add("BLACK");

        System.out.println("Before Addall.....");
        for(String s: vector){
            System.out.print(s + " ");
        }

        Collections.addAll(vector, institutes);

        System.out.println("\nAfter Addall.....");

        for(String s: vector){
            System.out.print(s + " ");
        }

        int freq = Collections.frequency(vector, "IIT");
        System.out.println("\nFrequency of IIT is: " + freq);

        boolean disjoint = Collections.disjoint(list, vector);
        System.out.println("Disjoint result: " + disjoint);

    }
}
