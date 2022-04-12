package Lab1_Generics;

public class EmptyStackException extends RuntimeException{

    public EmptyStackException(){
        this("Stack is empty");
    }

    public EmptyStackException( String exception ){
        super(exception);
    }
}
