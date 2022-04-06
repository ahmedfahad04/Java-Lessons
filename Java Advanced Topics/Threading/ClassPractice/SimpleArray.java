package ClassPractice;

import java.util.Arrays;
import java.util.Random;

public class SimpleArray {

    private final int array[];
    private int writeIndex = 0;
    private final static Random generator = new Random();

    public SimpleArray(int size){
        array = new int[size];
    }

    public void add(int value){

        int position = writeIndex;

        try{
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(), value, position);
        ++writeIndex;
        System.out.printf("Next write index: %d\n", writeIndex);
    }

    @Override
    public String toString() {
        String arrayString = "\nContents of SimpleArray\n";

        for(int i=0; i<array.length; i++){
            arrayString += array[i] + " ";
        }

        return arrayString;
    }
}
