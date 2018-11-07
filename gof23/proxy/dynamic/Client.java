package gof23.proxy.dynamic;

import gof23.proxy.RealStar;

import java.lang.reflect.Proxy;

/**
 * Created by admin on 2018/11/7.
 * 动态代理测试类
 * jdk动态代理原理：实现相关接口然后在每一个方法中调用handler类中的invoke
 */
public class Client {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        StarHandler starHandler = new StarHandler(realStar);

        // jdk代理为接口代理(star为接口)，proxy对象也实现了star接口
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandler);

        // 调用代理类订票和唱歌，每次调用方法都会进入invoke
        proxy.bookTicket();
        proxy.sing();
    }
}