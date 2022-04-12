package com.CollectionAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaSort {
    public static void main(String[] args) {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> allsuits = Arrays.asList(suits);
        int[] price = {10, 5, 12, 7};

        System.out.println("Before Sorting");
        for(String s: allsuits){
            System.out.print(s + " ");
        }

        Collections.sort(allsuits);
        System.out.println("\nAfter Sorting");
        for(String s: allsuits){
            System.out.print(s + " ");
        }

        //Collections.sort(allsuits, Collections.reverseOrder());
        Collections.reverse(allsuits);
        System.out.println("\nAfter Sorting in reverse Order");
        for(String s: allsuits){
            System.out.print(s + " ");
        }

        Arrays.sort(price);
        for(int a: price){
            System.out.println(a + " ");
        }

        // difference is Arrays.methods....works with mainly array time data
        // which deals with non-primitive data types

        // And Collections deal with Primitive data type and provide almost the
        // same functionality as of Arrays.
    }
}
