package code.me.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author nayunfeng
 * @date 2020/12/16 8:56
 * @description
 */
public class Task implements Runnable {

    private final CyclicBarrier cyclicBarrier;


    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is waiting");
            cyclicBarrier.await();
            System.out.println("Thread : " + Thread.currentThread().getName() + " is released");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
