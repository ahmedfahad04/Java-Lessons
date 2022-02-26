package com.CollectionAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{

    private final String name;
    private final Integer age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return o.age < this.age ? 1:-1; // ascending order
    }
}

public class JavaPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Person> payscale = new PriorityQueue<>();
        payscale.offer(new Person("Abdur Rahman", 55));
        payscale.offer(new Person("Mir Kashem", 53));
        payscale.offer(new Person("Abdur Rakib", 63));
        payscale.offer(new Person("Moshiur Rahman", 61));
        payscale.offer(new Person("Abdus Samad", 58));


        while(!payscale.isEmpty()){
            Person info = payscale.poll();
            System.out.println("NAME: " + info.getName() + ", Age: " + info.getAge());
        }

    }
}
