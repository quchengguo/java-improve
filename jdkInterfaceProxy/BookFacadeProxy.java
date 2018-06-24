package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by quchengguo on 2018/6/24.
 */
public class BookFacadeProxy implements InvocationHandler {
    // 这其实是业务实现类对象(BookFacadeImpl)，用来调用具体的业务方法
    private Object target;

    // 绑定业务对象并返回一个代理类
    public Object bind(Object target) {
        // 接收业务实现对象参数
        this.target = target;
        // 通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用是使用
        // 创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据）、接口、handler实现类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("预处理操作");
        // 调用真正的业务方法
        result = method.invoke(target, args);
        System.out.println("调用后处理");

        return result;
    }
}
