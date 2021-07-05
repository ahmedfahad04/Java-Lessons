package com.practice;

import java.util.Scanner;

/*
This problem shows how to take input until EOP(End of file)
 */

public class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean a;
        int i=1;
        while((a = sc.hasNext())){ //take input until end of line
            String x = sc.nextLine();
            System.out.println(i + " "+ x);
            i++;
        }

    }
}
