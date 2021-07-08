package com.practice;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Birthdate(DD/MM/YYYY): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, day);
        System.out.println(c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase());
    }
}
