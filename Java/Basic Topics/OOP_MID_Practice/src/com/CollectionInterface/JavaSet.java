package com.CollectionInterface;

import java.util.*;

public class JavaSet {
    public static void main(String[] args) {

        String[] names = {
                "yellow", "green", "black", "red", "blue",
                "green", "white", "yellow"
        };

        Set<String> cities = new HashSet<>();   // arbitrary ordered
        Set<String> cities2 = new LinkedHashSet<>();    // ordered as value entered
        TreeSet<String> cities3 = new TreeSet<>();  // sorted
        TreeSet<String> res = (TreeSet<String>) cities3.descendingSet(); // sorted in descending order

        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=0; i<num; i++){
            String x = sc.next();
            cities.add(x);
            cities2.add(x);
            res.add(x);
        }

        Iterator<String> it = cities.iterator();
        System.out.println("\nHASH SET..");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Iterator<String> it2 = cities2.iterator();
        System.out.println("\nLINKED HASH SET..");
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        Iterator<String> it3 = res.iterator();
        System.out.println("\nTREE SET..");
        while(it3.hasNext()){
            System.out.println(it3.next());
        }

        SortedSet<String> tree = new TreeSet<>(Arrays.asList(names));

        Iterator<String> it4 = tree.iterator();

        System.out.println("\nSortedSet..");
        while(it4.hasNext()){
            System.out.println(it4.next());
        }

//        System.out.println("TREE size: " + tree.size());

        System.out.println("Head Set..");
        SortedSet<String> headset = tree.headSet("red");
        Iterator<String> it5 = headset.iterator();


        while(it5.hasNext()){
            System.out.println(it5.next());
        }

        System.out.println("FIRST ELEMENT: " + tree.first());
        System.out.println("LAST ELEMENT: " + tree.last());

        tree.remove("red");
        System.out.println("TREE size: " + tree.size());


    }
}
