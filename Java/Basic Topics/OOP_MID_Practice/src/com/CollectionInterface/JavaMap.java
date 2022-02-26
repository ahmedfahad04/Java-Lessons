package com.CollectionInterface;

import java.util.*;

public class JavaMap {
    public static void main(String[] args) {

        Map<String, Integer> records = new HashMap<>();
        Scanner sc = new Scanner(System.in);

//        System.out.println("How many records: ");
//        int n = sc.nextInt();
//
//        for(int i=0; i<n; i++){
//            String name = sc.next();
//            int roll = sc.nextInt();
//            records.put(name, roll);
//        }

        records.put("Rowdy Rathor", 14);
        records.put("Kabir Sign", 18);
        records.put("Signham", 21);
        records.put("Khan", 19);

        System.out.println("Total Records: " + records.size());

        // print map
        Set<String> key = records.keySet();
        for(String name: key){
            System.out.println(name + ": " + records.get(name));
        }

        System.out.println("All values..");
        Collection<Integer> val = records.values();
        for(Integer roll: val){
            System.out.print(roll + " ");
        }
    }
}
