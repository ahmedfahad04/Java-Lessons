package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    public int phy;
    public int math;
    public int chem;
    public double avg;
    public String name;

    public Student(String name, int physics, int chemistry, int math) {
        this.phy = physics;
        this.chem = chemistry;
        this.math = math;
        this.name = name;
    }

    public double getavg() {
        this.avg = (phy + math + chem) / 3.0;
        return avg;
    }

    @Override
    public int compareTo(Student o) {
        if (o.getavg() > this.getavg()) {
            return 1;
        } else if (o.getavg() == this.getavg()) {
            if (o.phy > this.phy) return 1;
            else if (o.phy == this.phy) {
                if (o.chem > this.chem) {
                    return 1;
                } else if (o.chem == this.chem) {
                    if (o.math > this.math) {
                        return 1;
                    } else if (o.math == this.math) {
                        return (o.name.compareToIgnoreCase(this.name) > 0) ? 1 : -1;
                    } else {
                        return -1;
                    }
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
}

public class Main {
    public static void main(String[] args) {

        List<Student> bsse12 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("NAME: ");
            String name = sc.next();

            System.out.print("PHY: ");
            int phy = sc.nextInt();
            System.out.print("CHEM: ");
            int chem = sc.nextInt();
            System.out.print("MATH: ");
            int math = sc.nextInt();

            bsse12.add(new Student(name, phy, chem, math));
        }

        Collections.sort(bsse12);


        for (int i = 0; i < num; i++) {
            System.out.println("NAME: " + bsse12.get(i).name + ", PHYSICS: " +
                    bsse12.get(i).phy + ", CHEMISTRY: " + bsse12.get(i).chem +
                    ", MATH: " + bsse12.get(i).math + " ==> GPA: " + bsse12.get(i).getavg());

        }

    }
}
