package gof23.single;

/**
 * Created by admin on 2018/11/2.
 * 单例模式-懒汉式
 */
public class SingleLazyTest {
    public static void main(String[] args) {
        SingleLazy s1 = SingleLazy.getInstance();
        SingleLazy s2 = SingleLazy.getInstance();
        System.out.println(s1 == s2);
    }
}

class SingleLazy{
    private static SingleLazy singleLazy;

    // 私有化构造
    private SingleLazy(){}

    // 获取实例，有线程安全问题
    public static synchronized SingleLazy getInstance(){
        if(singleLazy == null){
            // 延迟加载
            singleLazy = new SingleLazy();
        }
        return singleLazy;
    }
}