package com.CollectionAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaSort {
    public static void main(String[] args) {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> allsuits = Arrays.asList(suits);

        System.out.println("Before Sorting");
        for(String s: allsuits){
            System.out.print(s + " ");
        }

        Collections.sort(allsuits);
        System.out.println("\nAfter Sorting");
        for(String s: allsuits){
            System.out.print(s + " ");
        }

        Collections.sort(allsuits, Collections.reverseOrder());
        System.out.println("\nAfter Sorting in reverse Order");
        for(String s: allsuits){
            System.out.print(s + " ");
        }
    }
}
