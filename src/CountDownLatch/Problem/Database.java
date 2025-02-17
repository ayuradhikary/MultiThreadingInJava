package CountDownLatch.Problem;

public class Database implements Runnable{
    @Override
    public void run() {
        System.out.println("Inserting some data in database");
        try {
            Thread.sleep(3000);
            System.out.println("Insertion completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
