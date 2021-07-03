package sample;

import java.io.*;
import java.util.Arrays;

public class Serialization {

    public static void write() {

        // Method 1: Array of Object;
        Student[] s = new Student[2];
        s[0] = new Student("Fahad","1204","SWE");
        s[1] = new Student("Asif","1216", "CSE");


        String filename = "data.bin";
        File f = new File(filename);
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File has been Created newly");
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(s);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Writing Done!!");
        }

    }

    public static void read(){
        Student[] ss;
        String filename = "data.bin";

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            ss = (Student[]) is.readObject();

            //System.out.println("Serialized object: " + Arrays.toString(ss));
            for(Student x: ss){
                System.out.println(x.name + ", " + x.id + ", "+ x.dept + "\n");
            }
            System.out.println("Reading Done!!");
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
