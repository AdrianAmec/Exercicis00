package com.project;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException,ExecutionException{
        
        ConcurrentHashMap<String, Double> sharedData = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        

        Runnable task1 = new Task1(sharedData);
        Runnable task2 = new Task2(sharedData);
        Callable<Double> task3 = new Task3(sharedData);

        

        CompletableFuture<Void> f1 = CompletableFuture.runAsync(task1,pool);
        CompletableFuture<Void> f2 = f1.thenRunAsync(task2,pool);

        Future<Double> montoFinal = f2.thenApplyAsync(v ->{
            try{
                return task3.call();
            }catch (Exception e){
                throw new  CompletionException(e);
            }
        });

        System.out.println("Main: El monto final es "+ String.valueOf(montoFinal.get()));


        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);


    }
}
