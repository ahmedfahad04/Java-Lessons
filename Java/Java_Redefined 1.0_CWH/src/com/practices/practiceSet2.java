/*
 * Practice problem on Different operators(logical/arithmatic)
 */

package com.practices;

import java.util.Scanner;

public class practiceSet2 {
    public static void main(String[] args) {

//        Question#2
        char grade = 'B';

        // Encrypt the grade
        grade = (char)(grade + 8);
        System.out.println(grade);

        // Decrypting the grade
        grade = (char)(grade - 8);
        System.out.println(grade);

//        Question#3
        Scanner sc = new Scanner(System.in);

        int given_num = 25;
        System.out.print("Enter your number: ");
        int num = sc.nextInt();

        if(num > given_num) System.out.println("GREATER");
        else if(num == given_num) System.out.println("EQUAL");
        else System.out.println("SMALLER");

//        Question#4
        int a = 7*49/7 + 35/7;
        System.out.println("Result: " + a);

    }
}
