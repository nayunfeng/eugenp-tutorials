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
 * @date 2020/12/21 13:21
 * @description
 */
class SynchronizedMethodsTest {

    @Test
    @Ignore
    void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(synchronizedMethods::calculate));

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedMethods.getSum());
    }

    @Test
    @Ignore
    void givenMultiThread_whenSyncMethod() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        SynchronizedMethods synchronizedMethods = new SynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(synchronizedMethods::synchronizedCalculate));

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedMethods.getSum());
    }

    @Test
    @Ignore
    void givenMultiThread_whenStaticSyncMethod() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(SynchronizedMethods::syncStaticCalculate));

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, SynchronizedMethods.staticSum);
    }

}