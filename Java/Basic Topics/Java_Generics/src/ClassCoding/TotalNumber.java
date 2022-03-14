package ClassCoding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TotalNumber {
    public static void main(String[] args) {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> integerList = new ArrayList<Integer>();

        for (Integer element: integers){
            integerList.add(element);
        }
        System.out.printf("IntegerList contains: %s ", integerList);
        System.out.printf("\nTotal of the element in numberList: %.1f\n", sum(integerList));

        Double[] doubles = {1.7, 2.44, 3.6, 4.54, 5.78, 6.8, 7.11};
        ArrayList<Double> doubleList = new ArrayList<Double>();

        for (Double element: doubles){
            doubleList.add(element);
        }
        System.out.printf("\nDoubleList contains: %s ", doubleList);
        System.out.printf("\nTotal of the element in numberList: %.1f\n", sum(doubleList));

        Number[] numbers = {1, 2, 3.6, 4, 5, 6.8, 7};
        ArrayList<Number> numberList = new ArrayList<Number>();

        for (Number element: numbers){
            numberList.add(element);
        }
        System.out.printf("\nNumberList contains: %s ", numberList);
        System.out.printf("\nTotal of the element in numberList: %.1f\n", sum(numberList));
    }

    public static double sum(ArrayList<? extends Number> list){

        double total = 0;

        for ( Number element: list){
            total += element.doubleValue();
        }

        return total;
    }
}
