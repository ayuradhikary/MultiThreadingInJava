package CountDownLatch.SolutionUsingCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Database implements Runnable{

    private CountDownLatch latch;

    public Database(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Inserting some data in database");
        try {
            Thread.sleep(3000);
            System.out.println("Insertion completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            latch.countDown();
        }
    }
}

