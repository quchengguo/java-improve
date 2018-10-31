package juc;

/**
 * Created by admin on 2018/10/31.
 * 题目：判断打印的 "one" or "two"
 * 1.两个普通的方法，两个线程，标准打印 // one two
 * 2.新增Thread.sleep() // one two
 * 3.新增普通方法getThree() // three one two
 * 4.两个普通同步方法，两个Number对象 // two one
 * 5.修改getOne为静态方法 // two one
 * 6.两个均修改为静态同步方法，一个Number对象 // one two
 * 7.一个静态方法，一个非静态方法，两个Number对象 // two one
 * 8.两个静态方法，两个Number方法 // one two
 *
 * 线程八锁的关键：
 * 1.非静态方法的默认锁为this，静态方法的锁为对应的Class实例
 * 2.某一个时刻内，只能有一个线程持有锁，无论几个方法
 */
public class Thread8MonitorTest {
    public static Number number = new Number();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                number.getTwo();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                number.getThree();
            }
        }).start();
    }
}

class Number {
    public synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("three");
    }
}
