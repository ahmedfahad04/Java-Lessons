package sample;

import java.util.ArrayList;
import java.util.Vector;

public class VectorArrayList {
    public static void sample(){
        // Method 1: Array of Object;
        Student[] s = new Student[2];
        s[0] = new Student("Fahad","1204","SWE");
        s[1] = new Student("Asif","1216", "CSE");

        // Method 2: Single object;
        Student ss = new Student("Rahat", "1121", "IBA");

        // Method 3: Vector of object;
        Vector<Student> vs = new Vector<>();
        vs.add(new Student("Sami","14785","ME"));
        vs.add(new Student("Zahif","14557","EEE"));

        // Method 4: ArrayList of object;
        ArrayList<Student> as = new ArrayList<>();
        as.add(new Student("Hasan", "5574","CE"));
        as.add(new Student("Kazi", "58774","WRE"));


        for(Student x: as){
            System.out.println(x);
        }

        for(Student x: vs){
            System.out.println(x);
        }

        System.out.println(ss);

        for(int i=0; i<2; i++){
            System.out.println(s[i]);
        }
    }
}
