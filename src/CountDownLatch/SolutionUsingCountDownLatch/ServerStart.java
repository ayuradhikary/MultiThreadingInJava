package CountDownLatch.SolutionUsingCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//using CountDownLatch we do not have to write get for every task to complete we can use await()
//this helps in an environment with large number of threads working

public class ServerStart {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Database database = new Database(latch);
        Cache cache = new Cache(latch);
        Logger logger = new Logger(latch);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(database);
        executor.submit(cache);
        executor.submit(logger);

        try {
            latch.await();
            System.out.println("Starting server");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            executor.shutdown();
        }


    }
}
