package ClassPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
    public static void main(String[] args) throws InterruptedException {

        // deals with thread synchronization....
        UpdatedSimpleArray sharedSimpleArray = new UpdatedSimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(writer1);
        executor.execute(writer2);

        executor.shutdown();

        try{
            boolean tasksEnd = executor.awaitTermination(1, TimeUnit.MINUTES);
            if(tasksEnd){
                System.out.println(sharedSimpleArray);
            }
            else{
                System.out.println("Timed out while waiting for tasks to finish");
            }
        } catch (InterruptedException ex){
            System.out.println("Interrupted while wait for tasks to finish.");
        }
    }
}
