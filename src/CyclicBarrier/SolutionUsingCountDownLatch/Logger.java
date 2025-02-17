package CyclicBarrier.SolutionUsingCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Logger implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public Logger(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Initializing logger");
        try {
            Thread.sleep(5000);
            System.out.println("Logger initialized");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}
