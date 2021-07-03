// shows how to use multiple generic type obj


public class part2 <T, S>{
    private T x;
    private S y;

    public part2(T obj, S obj2){
        x = obj;
        y = obj2;
    }

    public S getY() {
        return y;
    }

    public T getX(){
        return x;
    }

    public void showdata(){
        System.out.println("First Name: " + x);
        System.out.println("Last Name: " + y);
    }
}
