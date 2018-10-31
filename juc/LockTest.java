package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 2018/10/30.
 * 一、用户解决多线程安全的问题
 * synchronized:隐式锁
 * 1.同步代码块
 * 2.同步方法
 * JDK1.5后:显示锁
 * 3.同步锁Lock，通过unLock进行释放锁。更加灵活
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}
class Ticket implements Runnable{
    private int tick = 100;
    private Lock lock = new ReentrantLock();
    public void run() {
        while(true){
            lock.lock();
            try{
                if(tick > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票完成，余票为:" + --tick);
                }else{
                    // 没票了
                    break;
                }
            }finally {
                // 无论如何要把释放锁放在finally里
                lock.unlock();
            }
        }
    }
}