package sample;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public String id;
    public String dept;

    public Student(String name, String id, String dept) {
        this.name = name;
        this.id = id;
        this.dept = dept;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
