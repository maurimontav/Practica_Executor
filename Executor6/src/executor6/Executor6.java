/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package executor6;

/**
 *
 * @author pc
 */
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor6 {

    private static final Instant INICIO = Instant.now(); 

    public static void main(String[] args) {

	ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

	Runnable tarea= ()->{

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
              }

            Log("Ejecución de tarea");

	};

	scheduledExecutor.schedule(tarea, 3, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(tarea, 2, 1, TimeUnit.SECONDS);
        scheduledExecutor.scheduleWithFixedDelay(tarea, 2, 1, TimeUnit.SECONDS);

	try {
            TimeUnit.SECONDS.sleep(10);
	} catch (InterruptedException e) {
            e.printStackTrace();
          }

	scheduledExecutor.shutdown();

    }

    private static void Log(Object mensaje) {

	System.out.println(String.format("%s [%s] %s", 
        Duration.between(INICIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));

    }

}
