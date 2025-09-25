package com.project;
import java.util.concurrent.*;


public class Task implements Runnable{

    private int idTask;
    public static void main(String[] args) {
        
    }

    public Task(int id){
        this.idTask=id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task "+ idTask+" trabajando...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Task "+ idTask+" Acabo la feina...");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
