package CountDownLatch.SolutionUsingCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Cache implements Runnable{

    private CountDownLatch latch;

    public Cache(CountDownLatch latch){
        this.latch =  latch;
    }

    @Override
    public void run() {
        System.out.println("Initialzing caching");
        try {
            Thread.sleep(5000);
            System.out.println("cached completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            latch.countDown();
        }
    }
}
