package JavaMultiThreading.ReadWriteLocks;

public class ReadWriteLockImplementation {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable readtask = new Runnable() {
            @Override
            public void run() {
                counter.getCounter();
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                counter.increment();
            }
        };

        Thread readThread = new Thread(readtask,"readthread");
        Thread readThreadTwo = new Thread(readtask,"readthreadtwo");
        Thread readThreadThree = new Thread(readtask,"readthreadthree");


        Thread writeThread = new Thread(writeTask,"writethread");
        Thread writeThreadTwo = new Thread(writeTask,"writethreadtwo");
        Thread writeThreadThree = new Thread(writeTask,"writethreadthree");


        writeThread.start();
        writeThreadTwo.start();
        writeThreadThree.start();
        readThread.start();
        readThreadTwo.start();
        readThreadThree.start();

        readThread.join();
        readThreadTwo.join();
        readThreadThree.join();
        writeThread.join();
        writeThreadTwo.join();
        writeThreadThree.join();
    }

}