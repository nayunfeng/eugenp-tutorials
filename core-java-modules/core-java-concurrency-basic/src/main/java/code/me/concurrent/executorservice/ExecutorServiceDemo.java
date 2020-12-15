package code.me.concurrent.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author nayunfeng
 * @date 2020/12/15 13:40
 * @description
 */
public class ExecutorServiceDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void execute() {
        executorService.execute(Task::new);

        executorService.shutdown();
        executorService.shutdownNow();

        try {
            executorService.awaitTermination(20L, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
