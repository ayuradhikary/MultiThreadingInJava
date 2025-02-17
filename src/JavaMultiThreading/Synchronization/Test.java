package JavaMultiThreading.Synchronization;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread threadOne = new MyThread(counter);
        MyThread threadTwo = new MyThread(counter);

        threadOne.start();
        threadTwo.start();

        //to make sure the threads get completed
        threadOne.join();
        threadTwo.join();

        System.out.println(counter.getCount());

    }
}
