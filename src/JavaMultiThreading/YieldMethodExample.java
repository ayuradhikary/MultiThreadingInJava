package JavaMultiThreading;

class ThreadTest extends Thread{

    public ThreadTest(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i = 0; i < 50; i++){
            System.out.println(Thread.currentThread().getName()+" is running");
            Thread.yield();
        }
    }
}

public class YieldMethodExample {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("thread one");
        ThreadTest t2 = new ThreadTest("thread two");
        t1.start();
        t2.start();

    }
}
