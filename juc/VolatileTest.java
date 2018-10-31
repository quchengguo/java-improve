package juc;

/**
 * Created by admin on 2018/10/24.
 * Volatile关键字学习
 * JVM会为线程分配独立的缓存，所以每个线程中的变量相对于其他线程不可见
 * 注意：
 * 1.volatile不具备“互斥性”
 * 2.volatile不能保证变量的“原子性”
 */
public class VolatileTest {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        // 主线程执行
        while (true) {
            if (td.isFlag()) {
                System.out.println("-------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
//    private volatile boolean isFlag = false;  // volatile让其他线程可见(内存可见性)
    private boolean isFlag = false;

    public void run() {
        try {
            // 这里睡的时候，主线程会执行while(true)
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        isFlag = true;
        System.out.println("flag=" + isFlag);
    }

    public boolean isFlag() {
        return isFlag;
    }
}
