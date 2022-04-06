package Practice_1;

public class Main {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println(t);

        t.setName("Practice 1 thread");
        System.out.println(t.getName());

        System.out.println("Active Thread: " + Thread.activeCount());

    }
}
