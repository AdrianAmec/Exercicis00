package com.project;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        
        ExecutorService pool = Executors.newFixedThreadPool(2);
        

        Runnable task1 = new Task(1);
        Runnable task2 = new Task(2);

        pool.execute(task1);
        pool.execute(task2);

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

    }
}
