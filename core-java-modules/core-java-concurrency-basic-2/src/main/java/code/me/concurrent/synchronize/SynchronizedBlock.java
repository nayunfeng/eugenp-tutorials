package code.me.concurrent.synchronize;

/**
 * @author nayunfeng
 * @date 2020/12/21 13:13
 * @description
 */
public class SynchronizedBlock {

    private int count;
    private static int staticCount;

    public void performSynchronizedTask() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }
    public static synchronized void performStaticSynchronizedTask() {
        synchronized (SynchronizedBlock.class) {
            setStaticCount(getStaticCount() + 1);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public static void setStaticCount(int staticCount) {
        SynchronizedBlock.staticCount = staticCount;
    }
}
