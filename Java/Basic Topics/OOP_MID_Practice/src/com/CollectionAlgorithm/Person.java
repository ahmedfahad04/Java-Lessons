package com.CollectionAlgorithm;

public class Person implements Comparable<Person>{

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
        return o.name.compareToIgnoreCase(this.name) < 0 ? 1:-1; // ascending order
    }
}
