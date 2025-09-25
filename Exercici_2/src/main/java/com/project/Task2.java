package com.project;
import java.util.concurrent.*;


public class Task2 implements Runnable{

    ConcurrentHashMap<String, Double> sharedData;
    double interes;

    public Task2(ConcurrentHashMap<String, Double> sharedData){
        this.sharedData=sharedData;
    }

    @Override
    public void run() {
        try {
            interes=0.2;
            sharedData.compute("monto", (key, currentValue) -> {
            if (currentValue != null) {
                // Aplica interés al valor existente
                return currentValue + (currentValue * interes);
            } else {
                // Si la clave aún no está, lanza una excepción o devuelve un valor inicial (no recomendado aquí)
                
                System.out.println("Monto no inicializado por Task1.");
                return 0.0;
            }
            });
            // sharedData.computeIfPresent("monto", (key,value)-> value+(value * interes));
            TimeUnit.SECONDS.sleep(2);

            System.out.println("Task 2: aumentado intereses al monto");
            
            

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
