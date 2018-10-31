package juc;

/**
 * Created by admin on 2018/10/24.
 * CAS算法测试
 */
public class CompareAndSwapTest {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                public void run() {
                    int expectValue = cas.getValue();
                    boolean b = cas.compareAndSet(expectValue, (int)(Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    // 获取内存值
    public synchronized int getValue() {
        return value;
    }
    // 比较
    public synchronized int compareAndSwap(int expectValue, int newValue){
        int oldValue = value;
        if(oldValue == expectValue){
            this.value = newValue;
        }
        return oldValue;
    }
    // 设置
    public synchronized boolean compareAndSet(int expectValue, int newValue){
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}