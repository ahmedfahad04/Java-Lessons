package com.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class problem6 {
    public static void main(String[] args) {
        Date today = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int monthofYear = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
//        System.out.println("Day: " + today.getDay());

//        System.out.println("Day of week in number: "+dayOfMonth);
//        System.out.println("Month of the year in number: "+monthofYear);
//        System.out.println("Year: "+year);

        String day = new SimpleDateFormat("EEEE").format(today);
        System.out.println(day);
    }
}
