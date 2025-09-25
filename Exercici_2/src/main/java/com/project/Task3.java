package com.project;
import java.util.concurrent.*;


public class Task3 implements Callable<Double>{

    ConcurrentHashMap<String, Double> sharedData;
    Double monto;
    public Task3(ConcurrentHashMap<String, Double> sharedData){
        this.sharedData=sharedData;
    }

    @Override
    public Double call() {
        try {
            
            monto= sharedData.get("monto");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("Task3: El nuevo monto despues de intereses es de "+monto);            
            

        } catch (Exception e) {
            // TODO: handle exception
        }

        return monto;
    }

}
