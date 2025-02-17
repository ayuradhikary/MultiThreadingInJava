package JavaMultiThreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public  void  withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "Attempting to withdraw the amount: "+amount);

        try {
            if(lock.tryLock(4000,TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName()+" attempting to withdraw amount: "+amount);
                if(balance >= amount) {
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Balance withdrawl completed and remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();  //if the thread has been interrupted then this sets the interrupt flag to Y and when if we have to handle something in interruptions we can do that.
                        // if we do not do this then if any interuptions has had occured then the interruption state will be lost and we will never know if the thread was interrupted or not.
                        //It is generallly a good practice to do this and setting the interruption flag to Y if occures.
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+" Insufficient balance: "+balance);
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" Could not acquire the lock, we will try again later");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

       if(Thread.currentThread().isInterrupted()){
           System.out.println("Thread was interrupted");
       }


    }
}
