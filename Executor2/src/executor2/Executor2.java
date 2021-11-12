/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package executor2;

/**
 *
 * @author pc
 */
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor2 {
	
    private static final Instant INICIO = Instant.now(); 

    public static void main(String[] args) {

	ExecutorService executor = Executors.newSingleThreadExecutor();

	Runnable tarea= ()->{

            Log("Inicio de la tarea");

		try {
                    TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
                    e.printStackTrace();
                  }

            Log("Finaliza la tarea");

	};

	executor.submit(tarea);
	executor.shutdown();

    }

	

    private static void Log(Object mensaje) {

	System.out.println(String.format("%s [%s] %s", 
	Duration.between(INICIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));

    }

}
