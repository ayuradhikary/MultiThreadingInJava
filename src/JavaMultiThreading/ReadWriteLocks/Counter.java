package JavaMultiThreading.ReadWriteLocks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private int counter = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();



    public void increment(){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" Incremented");
            counter++;
            Thread.sleep(500);
        } catch (InterruptedException e) {

        } finally {
            System.out.println(Thread.currentThread().getName()+" Unlocking");
            writeLock.unlock();
        }
    }

    public int getCounter(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" read");
            return counter;
        }finally {
            System.out.println(Thread.currentThread().getName()+" unlocking");
            readLock.unlock();
        }
    }


}
