package code.me.concurrent.synchronize;

/**
 * @author nayunfeng
 * @date 2020/12/21 13:13
 * @description
 */
public class SynchronizedMethods {
    private int sum;
    private int syncSum;
    static int staticSum;

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronizedCalculate() {
        setSyncSum(getSyncSum() + 1);
    }

    public static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSyncSum() {
        return syncSum;
    }

    public void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }

}
