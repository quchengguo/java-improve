package juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by admin on 2018/10/31.
 * 1.读写锁
 * 写写互斥 读写互斥
 */
public class ReadWriteLockTest {
    public static ReadWriterLockDemo rwld = new ReadWriterLockDemo();
    public static void main(String[] args) {
        // 写
        new Thread(new Runnable() {
            public void run() {
                // nextInt(n)  0<=   <n
                rwld.set(new Random().nextInt(10));
            }
        },"write").start();
        // 读
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    rwld.get();
                }
            }, "read-"+i).start();
        } 
    }
}

class ReadWriterLockDemo {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    // 写
    public void set(int number) {
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}