package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2018/10/31.
 * lock也有自己的wait和notifyAll方法，分别对应为await和signalAll
 * lock进行线程通信通过condition
 */
public class ProductAndConsumerForLockTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Comsumer comsumer = new Comsumer(clerk);

        new Thread(productor, "生产者A").start();
        new Thread(comsumer, "消费者B").start();
    }
}

// 店员
class Clerk {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 进货
    public void get() {
        lock.lock();
        try {
            while (product >= 10) {
                System.out.println("满货");
                try {
//                   this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
//           this.notifyAll();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // 卖货
    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货");
                try {
                    // lock也有属于自己的wait和notify
//                    this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
//            this.notifyAll();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// 生产者
class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

// 消费者
class Comsumer implements Runnable {
    private Clerk clerk;

    public Comsumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}