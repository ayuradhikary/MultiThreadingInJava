package JavaMultiThreading;

public class MultiThreadingTest {
    public static void main(String[] args) throws InterruptedException {

        MultiThreadingExtendingThreadClass world = new MultiThreadingExtendingThreadClass(); // new state
        world.start(); // runnable state

//        MultiThreadingImplementingRunnableInterface world2 = new MultiThreadingImplementingRunnableInterface(); //new state
//        Thread threadOne = new Thread(world2);
//        threadOne.start(); //runnable state

        world.sleep(10000);
        world.interrupt();

        for(int i = 0; i < 100000; i++){
            System.out.println("Hello "+Thread.currentThread().getName());
        }
    }
}
