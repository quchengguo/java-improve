package gof23.single;

/**
 * Created by admin on 2018/11/2.
 * 单例-饿汉式
 */
public class SingleHungryTest {
    public static void main(String[] args) {
        SingleHungry s1 = SingleHungry.getInstance();
        SingleHungry s2 = SingleHungry.getInstance();
        System.out.println(s1 == s2); // true

    }
}

class SingleHungry {
    private static SingleHungry singleHungry = new SingleHungry();

    // 私有构造
    private SingleHungry() {
    }

    // 提供获取实例方法
    public static SingleHungry getInstance() {
        return singleHungry;
    }
}
