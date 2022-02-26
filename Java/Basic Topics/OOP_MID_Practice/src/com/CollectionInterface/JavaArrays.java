package com.CollectionInterface;

import java.util.Arrays;

public class JavaArrays {
    public static void main(String[] args) {
        int[] blankArray = new int[10];
        Arrays.fill(blankArray, 8);
        for(int x: blankArray){
            System.out.print("FILL: " + x + " ");
        }

        int[] letsSort = new int[] {81, 47, 58, 22, 49};
        System.out.println("\nUnsorted Array");
        for(int n: letsSort){
            System.out.print(n + " ");
        }
        Arrays.sort(letsSort);
        System.out.println("\nSorted Array");
        for(int n: letsSort){
            System.out.print(n + " ");
        }

        int x = Arrays.binarySearch(letsSort, 47);
        if(x == 1) System.out.println("\nFOUND....");
        else System.out.println("\nMISSED..");

        boolean equity = Arrays.equals(blankArray, letsSort);
        if(equity) System.out.println("MATCHED..");
        System.out.println("Different...");

        int[] copiedArray = new int[10];
        Arrays.fill(copiedArray, -1);
        System.arraycopy(letsSort, 0, copiedArray, 0, letsSort.length);
        System.out.println("Copied Array");
        for(int a: copiedArray){
            if(a > 0) System.out.print(a + " ");
        }

    }
}
