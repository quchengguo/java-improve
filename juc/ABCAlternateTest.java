package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2018/10/31.
 * ABC线程交替按照顺序打印: ABC ABC ABC
 */
public class ABCAlternateTest {
    public static AlternateDemo ad = new AlternateDemo();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    ad.loopA(i);
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    ad.loopB(i);
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    ad.loopC(i);
                    System.out.println("----------------------------------");
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {
    private int number = 1; // 目前正在执行线程的标记
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    /**
     * @param totalLoop 循环几轮
     */
    public void loopA(int totalLoop) {
        lock.lock();
        try {
            if (number != 1) {
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 1.打印
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            // 2.唤醒
            number = 2;
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) {
        lock.lock();
        try {
            if (number != 2) {
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 1.打印
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            // 2.唤醒
            number = 3;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();
        try {
            if (number != 3) {
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 1.打印
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            // 2.唤醒
            number = 1;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}
