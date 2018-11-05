package gof23.single;

/**
 * Created by admin on 2018/11/5.
 * 枚举天然单例，由JVM从根本上提供保障，避免通过反射和反序列化的漏洞
 * 缺点：无延迟加载
 */
public class SingleEnumTest {
    public static void main(String[] args) {
        SingleEnum instance = SingleEnum.getInstance();
        SingleEnum instance1 = SingleEnum.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}

enum SingleEnum {
    // 这个枚举元素本身就是单例对象
    INSTANCE;

    public static SingleEnum getInstance() {
        return INSTANCE;
    }
}
