package CountDownLatch.Problem;

public class Logger implements Runnable{
    @Override
    public void run() {
        System.out.println("Initializing logger");
        try {
            Thread.sleep(5000);
            System.out.println("Logger initialized");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
