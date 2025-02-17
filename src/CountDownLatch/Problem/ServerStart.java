package CountDownLatch.Problem;

import java.util.concurrent.*;

public class ServerStart {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Cache cache = new Cache();
        Database database = new Database();
        Logger logger = new Logger();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> futureCache =  executor.submit(cache,"cachesuccess");  // since runnable does not return any thing we passed a result
        Future<String> futureDatabase = executor.submit(database,"databasesuccess");
        Future<String> futureLogger = executor.submit(logger,"loggersuccess");

        futureCache.get();
        futureDatabase.get();
        futureLogger.get();

        executor.shutdown();
        System.out.println("server started! ");

    }
}
