package ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Example3InvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> callableOne = () -> {
            System.out.println("Task 1");
            return 1;
        };  //returns 1

        Callable<Integer> callableTwo = () -> {
            System.out.println("Task 2");
            return 2;
        };

        Callable<Integer> callableThree = () -> {
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callableOne, callableTwo, callableThree);

        List<Future<Integer>> futures = executor.invokeAll(list);

        for(Future<Integer> f: futures){
            System.out.println(f.get());
        }

        executor.shutdown();


//invokeall also blocks the main thread until all the threads are executed and tasks are completed.


    }
}
