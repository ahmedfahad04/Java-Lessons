package Generics;

public class TestCase {

    private Integer[] myroll = new Integer[]{1024, 2541, 14788, 1544};

    public void testQueue() {

        Queue roll = new Queue(10); // Raw Type
        testPush(roll, myroll);
        testPop(roll);
    }

    public <E> void testPush(Queue<E> roll, E[] rollList){
        System.out.println("Enqueuing new elements: ");

        for(E i: rollList){
            roll.enqueue(i);
            System.out.println("Pushing " + i);
        }
    }

    public <E> void testPop(Queue<E> roll){
        System.out.println("Dequeuing elements");
        E popval;

        while(!roll.isEmpty()){
            popval = roll.dequeue();
            System.out.println(popval + " --> dequeued");
            System.out.println("SIZE: " + roll.size());
        }
    }

    public static void main(String[] args) {
        TestCase tc = new TestCase();
        tc.testQueue();
    }
}

