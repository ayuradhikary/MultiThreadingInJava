package JavaMultiThreading.LambdaExpressionAndMultiThreading;

import static java.lang.Thread.sleep;

public class Implementation {
    public static void main(String[] args) {
        Runnable task = () -> {
            for(int i = 0; i < 5 ; i++){
                System.out.println("hello from "+Thread.currentThread().getName());
                try{
                    sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }

            }
        };

        Runnable taskTwo = () -> {
            for(int i = 0; i < 5 ; i++){
                System.out.println("hello from "+Thread.currentThread().getName());
            }
        };



        Thread threadOne = new Thread(task,"threadOne");
        Thread threadTwo = new Thread(taskTwo, "ThreadTwo");

        // we can directly do :-
        Thread threadThree = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println("hello from: "+Thread.currentThread().getName());
            }
        },"ThreadThree");

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
