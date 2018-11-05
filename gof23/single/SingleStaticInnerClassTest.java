package gof23.single;

/**
 * Created by admin on 2018/11/5.
 * 静态内部类实现的单例模式
 * 1.线程安全(类加载天然是线程安全的)
 * 2.懒加载
 * 这种充分利用JVM的特性
 */
public class SingleStaticInnerClassTest {

    public static void main(String[] args) {
        StaticInnerClass instance = StaticInnerClass.getInstance();
        StaticInnerClass instance1 = StaticInnerClass.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
class StaticInnerClass{
    private StaticInnerClass(){}
    private static class SingleClassInstance{
        private static final StaticInnerClass sc = new StaticInnerClass();
    }
    public static StaticInnerClass getInstance(){
        return SingleClassInstance.sc;
    }
}
