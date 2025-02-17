package ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//ScheduledExecutorService extends ExecutorService
//ScheduledExectorService extends ExecutorService

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> System.out.println("task executed after every 5 second delay"),5,5, TimeUnit.SECONDS);

        scheduler.schedule(() ->{
            System.out.println("Initiating shutdown");
            scheduler.shutdown();
        },20,TimeUnit.SECONDS);

//        scheduler.scheduleWithFixedDelay(() -> System.out.println("task executed after every 5 second delay"),5,5, TimeUnit.SECONDS);



    }
}
