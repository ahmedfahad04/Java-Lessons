// shows very basic way to work with generics
public class part1<T>{
    private final T obj;

    public part1(T obj){
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void showdata(){
        System.out.println("DATA TYPE: " + obj.getClass().getName());
        System.out.println("VALUE: " + obj);
    }
}

