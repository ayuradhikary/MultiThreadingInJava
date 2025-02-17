package CountDownLatch.Problem;

public class Cache implements Runnable{

    @Override
    public void run() {
        System.out.println("Initialzing caching");
        try {
            Thread.sleep(5000);
            System.out.println("cached completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
