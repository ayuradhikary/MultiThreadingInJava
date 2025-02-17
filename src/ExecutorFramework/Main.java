package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static long factorial(long n){
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(9);
        for(int i = 1; i < 10; i++){
            int finalI = i;
            executor.submit(() -> {
               long result = factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();

        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time: "+(System.currentTimeMillis() - startTime));
    }
}
