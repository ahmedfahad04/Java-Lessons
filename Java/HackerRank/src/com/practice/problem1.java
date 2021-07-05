package com.practice;

import java.util.Scanner;

/*
This problem shows how to use printf in java with alignment and showing leading zeroes.
 */

public class problem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();


            System.out.printf("%-15s%03d\n",s1,x); // left aligned and with one leading zero
        }
        System.out.println("================================");
    }
}
