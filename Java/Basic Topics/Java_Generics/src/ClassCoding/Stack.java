package ClassCoding;

class FullStackExeption extends RuntimeException{

    public FullStackExeption(){
        this("Stack is full");
    }

    public FullStackExeption (String exception){
        super(exception);
    }
}

public class Stack <E> {

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
        if (top == size){

        }
    }
}
