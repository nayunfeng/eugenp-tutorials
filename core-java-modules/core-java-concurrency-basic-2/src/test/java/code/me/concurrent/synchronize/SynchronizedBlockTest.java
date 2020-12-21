package code.me.concurrent.synchronize;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author nayunfeng
 * @date 2020/12/21 13:42
 * @description
 */
class SynchronizedBlockTest {


    @Test
    @Ignore
    void givenMultiThread_whenBlockSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        SynchronizedBlock synchronizedBlock = new SynchronizedBlock();

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(synchronizedBlock::performSynchronizedTask));

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedBlock.getCount());
    }

    @Test
    @Ignore
    void givenMultiThread_whenStaticBlockSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(SynchronizedBlock::performStaticSynchronizedTask));

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, SynchronizedBlock.getStaticCount());
    }

    @Test
    public void givenHoldingTheLock_whenReentrant_thenCanAcquireItAgain() {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("First time acquiring it");

            synchronized (lock) {
                System.out.println("Entering again");

                synchronized (lock) {
                    System.out.println("And again");
                }
            }
        }
    }
}