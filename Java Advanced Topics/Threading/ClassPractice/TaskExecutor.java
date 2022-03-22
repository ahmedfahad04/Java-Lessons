package ClassPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    // deals with the idea of thread pool

    public static void main(String[] args) {

        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        threadExecutor.shutdown();

        System.out.println("Task Started, main ends..\n");

    }
}
