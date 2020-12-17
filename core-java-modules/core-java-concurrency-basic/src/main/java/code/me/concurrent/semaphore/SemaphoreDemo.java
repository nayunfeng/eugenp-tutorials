package code.me.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author nayunfeng
 * @date 2020/12/16 9:16
 * @description The Semaphore is used for blocking thread level access to some part of the physical or logical resource.
 * A semaphore contains a set of permits; whenever a thread tries to enter the critical section,
 * it needs to check the semaphore if a permit is available or not.
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(10);

    public void execute() {
        System.out.println("Available permit : " + semaphore.availablePermits());
        System.out.println("Number of threads waiting to acquire : " + semaphore.getQueueLength());

        if (semaphore.tryAcquire()) {
            try {
                // perform some critical operations
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.execute();
    }
}
