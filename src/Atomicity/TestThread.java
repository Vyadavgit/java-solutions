package Atomicity;

public class TestThread {
    public static void main(String[] args) {
        RunnableImpl runnableTask = new RunnableImpl();
        Thread thread = new Thread(runnableTask);
        thread.start(); // prints "Thread started"
    }
}
