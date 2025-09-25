package com.project;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException,ExecutionException{
        
        
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() ->{

            try {
                System.out.println("primera tasca: Validando Datos. ");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("primera tasca: Datos validados. ");
                return 10;
            } catch (Exception e) {
                // TODO: handle exception
                throw new IllegalStateException(e);
            }
            

        });

        CompletableFuture<String> f2= f1.thenApply(dato ->{
            
            try {
                System.out.println("seguna tasca: Procesando los datos.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("seguna tasca: Datos prosesados.");
                
            } catch (Exception e) {
                // TODO: handle exception
            }
            String resultat= "el dato "+dato+" es "+dato*2+".";
            return resultat;
        });

        CompletableFuture<Void> f3=f2.thenAccept(resultat -> {
            try {
                
                System.out.println("tercera tasca: generando respuesta a usuario.");

                TimeUnit.SECONDS.sleep(2);
                
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("--- RESPUESTA FINAL AL USUARIO ---");
            System.out.println(resultat);
            System.out.println("----------------------------------");
        });

        f3.join();

    }
}
