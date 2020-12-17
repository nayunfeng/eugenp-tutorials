package code.me.concurrent.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author nayunfeng
 * @date 2020/12/16 9:30
 * @description
 */
public class ThreadFactoryDemo {

    public void execute() {
        ThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");

        for (int i = 0; i < 10; i++) {
            Thread t = threadFactory.newThread(() -> {
                System.out.println("This is a task");
            });
            t.start();
        }
    }

    public static void main(String[] args) {
        ThreadFactoryDemo threadFactoryDemo = new ThreadFactoryDemo();
        threadFactoryDemo.execute();
    }
}
