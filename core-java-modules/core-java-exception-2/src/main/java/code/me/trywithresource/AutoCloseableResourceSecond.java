package code.me.trywithresource;

import java.io.Closeable;

/**
 * @author nayunfeng
 * @date 2020/12/17 9:49
 * @description
 */
public class AutoCloseableResourceSecond implements AutoCloseable{

    public AutoCloseableResourceSecond() {
        System.out.println("Constructor -> AutoCloseableResourceSecond");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResourceSecond");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close -> AutoCloseableResourceSecond");
    }
}
