package CyclicBarrier.SolutionUsingCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Database implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public Database(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Inserting some data in database");
        try {
            Thread.sleep(3000);
            System.out.println("Insertion completed");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}

