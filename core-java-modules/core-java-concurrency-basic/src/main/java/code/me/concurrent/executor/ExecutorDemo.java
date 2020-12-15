package code.me.concurrent.executor;

import java.util.concurrent.Executor;

/**
 * @author nayunfeng
 * @date 2020/12/15 13:44
 * @description
 */
public class ExecutorDemo {

    public void execute(){
        Executor executor = new Invoker();
        executor.execute(() -> {
            System.out.println("执行任务");
        });
    }
}
