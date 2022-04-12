package com.CollectionAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaPriorityQueue {

    public static void main(String[] args) {

        Comparator<Person> age = Comparator.comparing(Person::getAge);
        PriorityQueue<Person> payscale = new PriorityQueue<>(age);
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
