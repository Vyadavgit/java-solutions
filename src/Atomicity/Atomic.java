package Atomicity;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounterCopy {
    private AtomicInteger count = new AtomicInteger();

    public void increment(){
        count.incrementAndGet();
    }

    public int geCount(){
        return count.get();
    }
}

public class Atomic {

    public static void main(String[] args) {
        SharedCounterCopy sharedCounter = new SharedCounterCopy();

        // Thread 1
        new Thread(() -> {
            System.out.println("Thread 1 started");
            for(int i = 0; i < 50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread 1 completed");
        }).start();

        // Thread 2
        new Thread(()->{
            System.out.println("Thread 2 started");
            for(int i = 0; i < 50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread 2 completed");
        }).start();

        // give threads time to complete tasks
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final count: " + sharedCounter.geCount()); // prints correct output 100000 (if thread 1 wins the race condition, thread 2 has to wait untill 1 is done)
    }
    
}
