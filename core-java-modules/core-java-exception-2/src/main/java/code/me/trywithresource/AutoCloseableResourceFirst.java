package code.me.trywithresource;

import java.io.Closeable;

/**
 * @author nayunfeng
 * @date 2020/12/17 9:48
 * @description
 */
public class AutoCloseableResourceFirst implements AutoCloseable {

    public AutoCloseableResourceFirst() {
        System.out.println("Constructor -> AutoCloseableResourceFirst");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResourceFirst");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close -> AutoCloseableResourceFirst");
    }
}
