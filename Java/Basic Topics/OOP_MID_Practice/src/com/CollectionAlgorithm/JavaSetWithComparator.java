package com.CollectionAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class JavaSetWithComparator {
    public static void main(String[] args) {

        Comparator<Person> name = Comparator.comparing(Person::getName);
        TreeSet<Person> ans = new TreeSet<Person>(name);
        TreeSet<Person> res = (TreeSet<Person>) ans.descendingSet();

        Person p1 = new Person("Fahad", 21);
        Person p2 = new Person("Asad", 22);
        Person p3 = new Person("Sabit", 20);

        ans.addAll(Arrays.asList(p1, p2, p3));
        for(Person p: ans){
            System.out.println(p.getName() + " " + p.getAge());
        }

    }
}

