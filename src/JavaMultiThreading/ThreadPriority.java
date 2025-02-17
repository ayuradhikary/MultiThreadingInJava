package JavaMultiThreading;

class TestThread extends Thread{

    public TestThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            String a = "";
            for (int j=0; j<10000; j++){
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " priority: "+ Thread.currentThread().getPriority() + " count : "+i);
            try{
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }
}


public class ThreadPriority {
    public static void main(String[] args) {
        TestThread threadOne = new TestThread("High priority Thread");
        TestThread threadTwo = new TestThread("Minimum priority Thread");
        TestThread threadThree = new TestThread("Normal Priority Thread");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadTwo.setPriority(Thread.MIN_PRIORITY);
        threadThree.setPriority(Thread.NORM_PRIORITY);
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
