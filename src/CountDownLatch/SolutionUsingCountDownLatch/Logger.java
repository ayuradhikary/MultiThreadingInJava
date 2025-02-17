package CountDownLatch.SolutionUsingCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Logger implements Runnable{

    private CountDownLatch latch;

    public Logger(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Initializing logger");
        try {
            Thread.sleep(5000);
            System.out.println("Logger initialized");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            latch.countDown();
        }
    }
}
