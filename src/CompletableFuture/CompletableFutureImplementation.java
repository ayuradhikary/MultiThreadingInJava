package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImplementation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> greeting = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        try {
            System.out.println(greeting.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture<String> greetingTwo = CompletableFuture.supplyAsync(() -> {
           return "World";
        });

        CompletableFuture<String> combinedGreeting = greeting.thenCombine(greetingTwo, (m1,m2) ->  m1 +" "+m2);

        try {
            System.out.println(combinedGreeting.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //Handling exceptions

        //we can provide a fallback value or perform some alternative operations
        //if we encounter an exception during asynchronous computation

        CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return 10/0;
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               return 0;
            }
        }).exceptionally(ex -> 0);

//        futureResult.thenAccept(result -> {
//            System.out.println("Result: " + result);
//        });

        System.out.println(futureResult.get());

        System.out.println("Main");


    }
}
