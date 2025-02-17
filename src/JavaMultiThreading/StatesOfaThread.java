package JavaMultiThreading;


class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
public class StatesOfaThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread threadOne = new MyThread();
        System.out.println(threadOne.getState()); // new state
        threadOne.start();
        System.out.println(threadOne.getState()); //runnable state

        System.out.println(Thread.currentThread().getState()); // for main thread

        Thread.sleep(100);

        System.out.println(threadOne.getState()); //Witing

        threadOne.join(); //only when the threadOne gets completed the main thread will run, bascially waits for  the ThreadOne to execute.
        System.out.println(threadOne.getState()); //terminated

    }
}
