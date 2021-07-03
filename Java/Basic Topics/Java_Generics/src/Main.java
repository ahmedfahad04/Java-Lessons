public class Main {
    public static void main(String [] args){

        System.out.println("\nPART 1:");
        part1<String> num = new part1<>("50");
        num.showdata();

        System.out.println("\nPART 2:");
        part2<String, String> names = new part2<>("Istiaq Ahmed", "Fahad");
        names.showdata();

        System.out.println("\nPART 3:");
        Double[] array = { 2.0, 4.0};

        part3<Double> operate = new part3<>(array);

        double x = operate.avg();
        System.out.println("AVG: " + x);
    }

}

// NB: I didn't need to import the part1 class. when the classes are from different package you need to import them.

