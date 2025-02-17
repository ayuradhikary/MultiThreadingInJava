package JavaMultiThreading.Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment(){ //synchronized method that synchronizes the whole method
       count++;
    }

    // public void increment(){
     //   synchronized (this){   //block synchronization, this does not synchronizes the whole method but only synchronizes the block
      //      count++;
       // }

    //}


    public int getCount(){
        return count;
    }

}
