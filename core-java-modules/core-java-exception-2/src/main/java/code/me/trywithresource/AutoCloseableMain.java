package code.me.trywithresource;

/**
 * @author nayunfeng
 * @date 2020/12/17 9:51
 * @description
 */
public class AutoCloseableMain {

    public static void main(String[] args) throws Exception {
        orderOfClosingResource();
    }

    /**
     * 验证资源的关闭顺序，先定义的最后关闭
     * @throws Exception e
     */
    private static void orderOfClosingResource() throws Exception {
        try(AutoCloseableResourceFirst first = new AutoCloseableResourceFirst();
            AutoCloseableResourceSecond second = new AutoCloseableResourceSecond()) {

            first.doSomething();
            second.doSomething();
        }
    }
}
