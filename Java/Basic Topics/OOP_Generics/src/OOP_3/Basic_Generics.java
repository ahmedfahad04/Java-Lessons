package OOP_3;

public class Basic_Generics {
    public static void main(String[] args) {

        Integer[] numbers = {10, 14, 15, 19};
        Double[] marks = {85.6, 89.1, 78.6, 96.5};
        String[] names = {"Asad", "Rashed", "Jalil"};
        printList(numbers); 

    }

    public static <T> void printList(T[] List){

        // a generic iteration
        for(T a: List){
            System.out.println("Element: " + a);
        }
    }
}
