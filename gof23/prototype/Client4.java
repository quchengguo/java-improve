package gof23.prototype;

/**
 * Created by admin on 2018/11/6.
 * 什么情况下使用原型模式?使用new耗时间
 */
public class Client4 {
    public static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Laptop laptop = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用new方式耗时:" + (end - start));
    }

    public static void testClone(int size) {
        long start = System.currentTimeMillis();
        Laptop laptop = new Laptop();
        for (int i = 0; i < size; i++) {
            try {
                Laptop temp = (Laptop) laptop.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("使用克隆方式耗时:" + (end - start));
    }

    public static void main(String[] args) {
        testNew(1000);
        testClone(1000);
    }
}

/**
 * 笔记本电脑
 */
class Laptop implements Cloneable {
    public Laptop() {
        try {
            // 模拟创建对象耗时的过程
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
