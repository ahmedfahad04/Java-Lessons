package com.concepts;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int day = sc.nextInt();
//        int month = sc.nextInt();
//        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c2.set(Calendar.YEAR, 1999);
        c2.set(Calendar.MONTH, 11);
        c2.set(Calendar.DATE, 29);

        System.out.println(c.getTime());
        System.out.println(c2.get(Calendar.ERA));
        c2.toInstant();
    }
}
