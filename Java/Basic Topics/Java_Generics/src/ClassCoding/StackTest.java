package ClassCoding;

class FullStackException extends RuntimeException{

    public FullStackException(){
        this("Stack is full");
    }

    public FullStackException (String exception){
        super(exception);
    }
}

class EmptyStackException extends RuntimeException{

    public EmptyStackException(){
        this("Stack is empty");
    }

    public EmptyStackException( String exception ){
        super(exception);
    }
}

class Stack <E> {

    private final int size;
    private int top;
    private E[] elements;

    public Stack() {
        this(10);
    }

    public Stack(int s){
        size = s > 0 ? s : 10;
        top = -1;
        elements = (E[]) new Object[size];
    }

    public void push(E pushValue){
        if (top == size - 1){
            throw new FullStackException(String.format("Stack is full, cannot push %s", pushValue));
        }
        elements[++top] = pushValue;
    }

    public E pop(){
        if(top == -1){
            throw new EmptyStackException("Stack is empty, cannot pop");
        }

        return elements[top--];
    }
}

public class StackTest {


    private double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
    private int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    private Stack <Double> doubleStack;
    private Stack <Integer> integerStack;

    public void testStacks(){
        doubleStack = new Stack<Double>(5);
        integerStack = new Stack<Integer>(10);

        testPushDouble();
        testPopDouble();
        testPushInteger();
        testPopInteger();
    }


    public void testPushDouble(){
        try{
            System.out.println("\nPushing elements onto doubleStack");

            for (double element: doubleElements){
                System.out.printf("%.1f ", element);
                doubleStack.push(element);
            }
        } catch (FullStackException fullStackException){
            System.err.println();
            fullStackException.printStackTrace();
        }
    }

    public void testPopDouble(){
        try{
            System.out.println("\nPoping elements from doubleStack");
            double popValue;

            while(true){

                popValue = doubleStack.pop();
                System.out.printf("%.1f ", popValue);
            }
        } catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
    }

    public void testPushInteger(){
        try{
            System.out.println("\nPushing elements into intStack");

            for (int element: integerElements){
                System.out.printf("%d ", element);
                integerStack.push(element);
            }
        } catch (FullStackException fullStackException){
            System.err.println();
            fullStackException.printStackTrace();
        }
    }

    public void testPopInteger(){
        try{
            System.out.println("\nPoping elements from integerStack");
            int popValue;

            while(true){

                popValue = integerStack.pop();
                System.out.printf("%d ", popValue);
            }
        } catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StackTest application = new StackTest();
        application.testStacks();
    }


}