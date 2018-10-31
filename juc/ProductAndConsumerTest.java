package juc;

/**
 * Created by admin on 2018/10/30.
 * 等待-唤醒机制: wait-notifyAll
 */
public class ProductAndConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Comsumer comsumer = new Comsumer(clerk);

        new Thread(productor, "生产者A").start();
        new Thread(comsumer, "消费者B").start();
    }
}

// 店员
//class Clerk {
//    private int product = 0;
//
//    // 进货
//    public synchronized void get() {
//        while (product >= 10) {
//            System.out.println("满货");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + ++product);
//        this.notifyAll();
//
//    }
//
//    // 卖货
//    public synchronized void sale() {
//        while (product <= 0) {
//            System.out.println("缺货");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + --product);
//        this.notifyAll();
//    }
//}
//
//// 生产者
//class Productor implements Runnable {
//    private Clerk clerk;
//
//    public Productor(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            clerk.get();
//        }
//    }
//}
//
//// 消费者
//class Comsumer implements Runnable {
//    private Clerk clerk;
//
//    public Comsumer(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            clerk.sale();
//        }
//    }
//}
