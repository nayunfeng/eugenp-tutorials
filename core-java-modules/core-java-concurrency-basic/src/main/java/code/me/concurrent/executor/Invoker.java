package code.me.concurrent.executor;

import java.util.concurrent.Executor;

/**
 * @author nayunfeng
 * @date 2020/12/15 13:27
 * @description
 */
public class Invoker implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

}
