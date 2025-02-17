package CyclicBarrier.SolutionUsingCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Cache implements Runnable{

    private CyclicBarrier barrier;

    public Cache(CyclicBarrier barrier){
        this.barrier =  barrier;
    }

    @Override
    public void run() {
        System.out.println("Initialzing caching");
        try {
            Thread.sleep(5000);
            System.out.println("cached initialized");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}
