package gof23.strategy;

/**
 * Created by admin on 2018/11/12.
 * 策略模式测试
 * 怎么又是：if .. else if .. else if ...
 * 应用场景:
 * spring框架中Resource接口，资源访问策略
 * javax.servlet.http.httpServlet#service()
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new NewCustomerFewStrategy();
        Context context = new Context(strategy);
        context.printPrice(10);
    }
}