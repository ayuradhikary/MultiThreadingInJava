package CyclicBarrier.SolutionUsingCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//using CountDownLatch we do not have to write get for every task to complete we can use await()
//this helps in an environment with large number of threads working

public class ServerStart {
    public static void main(String[] args) {
        int numberOfParties = 3;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfParties, () -> {
            System.out.println("All components initialized");
        }); //once all the threads are in barrier the "All components initialized will be printed

        Database database = new Database(cyclicBarrier);
        Cache cache = new Cache(cyclicBarrier);
        Logger logger = new Logger(cyclicBarrier);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(database);
        executor.submit(cache);
        executor.submit(logger);

        executor.shutdown();
        System.out.println("main");


//main thread does not wait for barriers

    }
}
