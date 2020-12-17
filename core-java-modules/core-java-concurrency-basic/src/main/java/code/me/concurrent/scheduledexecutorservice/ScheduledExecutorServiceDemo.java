package code.me.concurrent.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author nayunfeng
 * @date 2020/12/17 8:48
 * @description ScheduledExecutorService is a similar interface to ExecutorService, but it can perform tasks periodically.
 */
public class ScheduledExecutorServiceDemo {

    public void execute() {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        getTasksToRun().apply(scheduledExecutorService);
        scheduledExecutorService.shutdown();
    }

    public void executeMultiThread() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        getTasksToRun().apply(scheduledExecutorService);
        scheduledExecutorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksToRun() {
        return scheduledExecutorService -> {

            ScheduledFuture<String> scheduledFuture1 = scheduledExecutorService
                    .schedule(() -> "Hello World", 1, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture2 = scheduledExecutorService
                    .schedule(() -> {
                    }, 1, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture3 = scheduledExecutorService
                    .scheduleAtFixedRate(() -> {

                    }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture4 = scheduledExecutorService
                    .scheduleWithFixedDelay(() -> {
                    }, 1, 10, TimeUnit.SECONDS);

            return null;
        };
    }

    public static void main(String[] args) {
        ScheduledExecutorServiceDemo scheduledExecutorServiceDemo = new ScheduledExecutorServiceDemo();
        scheduledExecutorServiceDemo.execute();
        scheduledExecutorServiceDemo.executeMultiThread();
    }

}
