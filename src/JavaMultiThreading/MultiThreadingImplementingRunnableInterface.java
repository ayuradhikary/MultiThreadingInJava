package JavaMultiThreading;

public class MultiThreadingImplementingRunnableInterface implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            System.out.println("Hello World"+Thread.currentThread().getName());
        }
    }
}
