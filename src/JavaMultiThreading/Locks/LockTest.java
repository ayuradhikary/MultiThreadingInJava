package JavaMultiThreading.Locks;

import JavaMultiThreading.MultiThreadingExtendingThreadClass;

public class LockTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        //instead of using Thread class we are using runnable interface for this using anonymous class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }

}
