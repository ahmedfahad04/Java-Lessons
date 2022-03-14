package com.company;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {

    public String name;
    public int age;
    public int roll;

    public Person(int age, String name, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareToIgnoreCase(o.name) == 0) {
            if (this.age > o.age) {
                if (this.roll > o.roll) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }

        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", roll=" + roll +
                '}';
    }
}

public class test {

    public static void main(String[] args) {
        ArrayList<Person> p = new ArrayList<Person>();
        p.add(new Person(12, "Saif", 1204));
        p.add(new Person(15, "Rashed", 1255));
        p.add(new Person(14, "Saif", 1299));

        Collections.sort(p);

        for (Person x : p) {
            System.out.println(x.toString());
        }
    }
}
