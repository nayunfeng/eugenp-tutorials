package code.me.concurrent.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author nayunfeng
 * @date 2020/12/16 9:26
 * @description
 */
public class MyThreadFactory implements ThreadFactory {
    private int threadId;
    private final String name;

    public MyThreadFactory(String name) {
        this.threadId = 1;
        this.name = name;
    }

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + threadId);
        System.out.println("created new thread with id : " + threadId + " and name :" + thread.getName());
        threadId++;
        return thread;
    }
}
