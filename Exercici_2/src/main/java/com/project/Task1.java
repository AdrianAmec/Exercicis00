package com.project;
import java.util.concurrent.*;


public class Task1 implements Runnable{

    ConcurrentHashMap<String, Double> sharedData;
    Double monto;

    public Task1(ConcurrentHashMap<String, Double> sharedData){
        this.sharedData=sharedData;
    }

    @Override
    public void run() {
        try {
            monto=20.0;

            TimeUnit.SECONDS.sleep(2);

            sharedData.put("monto", monto);
            
            System.out.println("Task1: Obtenido el monto"+ monto);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
