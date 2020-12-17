package code.me.concurrent.future;

import java.util.concurrent.*;

/**
 * @author nayunfeng
 * @date 2020/12/16 8:41
 * @description Future用于表示异步操作的结果。它提供了检查异步操作是否完成、获取计算结果等方法。
 */
public class FutureDemo {

    public String invoke() {
        String str = null;

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(10_000);
            return "Hello World";
        });

        /*
        the cancel(boolean mayInterruptIfRunning) API cancels the operation and releases the executing thread.
        If the value of mayInterruptIfRunning is true, the thread executing the task will be terminated instantly.
         */
        future.cancel(false);

        /*
        We can also specify a timeout for a given operation.
        If the task takes more than this time, a TimeoutException is thrown
         */
        try {
            future.get(20, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        /*
        We can use following code snippet to check if the future result is ready and fetch the data if the computation is done
         */
        if (future.isDone() && !future.isCancelled()) {
            try {
                str = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return str;
    }

    public static void main(String[] args) {
        FutureDemo futureDemo = new FutureDemo();
        String result = futureDemo.invoke();
        System.out.println(result);
    }

}
