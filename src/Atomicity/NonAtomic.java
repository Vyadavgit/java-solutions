package Atomicity;

class SharedCounter {
    private int count;

    public void increment(){
        count++;
    }

    public int geCount(){
        return count;
    }
}

public class NonAtomic {

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

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

        System.out.println("Final count: " + sharedCounter.geCount()); // creates race condition and returns incorrect input
    }
    
}
