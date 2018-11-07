package gof23.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/11/7.
 * 动态代理
 * 应用场景：AOP 远程调用
 */
public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 统一的流程控制
        System.out.println("StarHandler invoke");
        Object obj = null;
        System.out.println("真正的方法执行前");
        System.out.println("面谈，签合同，预付款，订机票");
        if(method.getName().equalsIgnoreCase("sing")){
            obj = method.invoke(realStar, args);
        }
        System.out.println("真正的方法执行后");
        System.out.println("收尾款");
        return obj;
    }
}