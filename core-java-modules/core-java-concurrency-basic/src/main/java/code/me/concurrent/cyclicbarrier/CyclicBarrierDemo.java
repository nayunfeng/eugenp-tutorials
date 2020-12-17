package code.me.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author nayunfeng
 * @date 2020/12/16 8:59
 * @description
 * CyclicBarrier works almost the same as CountDownLatch except that we can reuse it.
 * Unlike CountDownLatch, it allows multiple threads to wait for each other using await()
 * method(known as barrier condition) before invoking the final task.
 */
public class CyclicBarrierDemo {

    public void start() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // Task
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

        /*
        Here, the isBroken() method checks if any of the threads got interrupted during the execution time.
        We should always perform this check before performing the actual process.
         */
        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.start();
    }
}
