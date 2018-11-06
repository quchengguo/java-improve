package gof23.proxy;

/**
 * Created by admin on 2018/11/6.
 * 代理模式：控制对对象的访问，可以在某个方法的前置后置做处理，AOP微观实现
 * 应用场景：安全代理、远程代理、延迟加载
 * 测试类
 * 和客户直接打交道的是经纪人而非真正的明星
 */
public class Client {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        ProxyStar proxyStar = new ProxyStar(realStar);

        proxyStar.confer();
        proxyStar.bookTicket();

        // 客户找经纪人唱歌，经纪人找明星本人
        proxyStar.sing();
    }
}
