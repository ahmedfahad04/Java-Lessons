package Lab1_Generics;

public class FullStackException extends RuntimeException{

    public FullStackException(){
        this("Stack is full");
    }

    public FullStackException (String exception){
        super(exception);
    }
}
