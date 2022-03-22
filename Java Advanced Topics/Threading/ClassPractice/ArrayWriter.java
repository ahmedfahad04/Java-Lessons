package ClassPractice;

public class ArrayWriter implements Runnable {

    private final UpdatedSimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int value, UpdatedSimpleArray array){
        startValue = value;
        sharedSimpleArray = array;
    }

    public void run(){
        for(int i = startValue; i<startValue+3; i++){
            sharedSimpleArray.add(i);
        }
    }
}
