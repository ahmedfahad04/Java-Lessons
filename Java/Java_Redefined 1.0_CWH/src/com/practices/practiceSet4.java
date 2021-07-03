/*
 *Practice problem on If-else statement.
 */

package com.practices;

import java.util.Scanner;

public class practiceSet4 {
    public static void main(String[] args) {
//        //Question 2
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter marks of each subject: ");
//
//        System.out.print("Math: ");
//        int math = sc.nextInt();
//
//        System.out.print("Physics: ");
//        int physics = sc.nextInt();
//
//        System.out.print("Chemistry: ");
//        int chem = sc.nextInt();
//        float total = (math + chem + physics)/3.0f;
//        if(math > 33 && physics > 33 && chem > 33 && total > 40) System.out.println("Passed!");
//        else System.out.println("Failed");
//
//        //Question 3
//        System.out.print("Enter amount of tax you have paid: ");
//        int tax = sc.nextInt();
//
//        //Question 4
//        int day = sc.nextInt();
//        switch (day){
//            case 1 -> System.out.println("Monday");
//            case 2 -> System.out.println("Tuesday");
//            case 3 -> System.out.println("Wednesday");
//            case 4 -> System.out.println("Thursday");
//            case 5 -> System.out.println("Friday");
//            case 6 -> System.out.println("Saturday");
//            case 7 -> System.out.println("Sunday");
//        }

//        // Question 5
//        System.out.print("Enter year: ");
//        int year = sc.nextInt();
//
//        if (year %400 == 0 || (year%4==0 && year%100!=0)){
//            System.out.printf("%d is a leap year.", year);
//        }
//        else     System.out.printf("%d is not a leap year.", year);

        // Question 6
        System.out.print("Enter website name: ");
        String web = sc.nextLine();
        if(web.endsWith(".com")) System.out.println("Commercial Website");
        else if(web.endsWith(".org")) System.out.println("Organizational Website");
        else if(web.endsWith(".bd")) System.out.println("Bangladeshi Website");
    }


}
