package gof23.strategy;

/**
 * Created by admin on 2018/11/12.
 * 上下文类,，用来管理算法(接口扩展类)的
 * 算法彻底和客户端分离
 */
public class Context {
    // 当前采用的算法
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double s){
        System.out.println("报价前操作");
        System.out.println("报价:" + strategy.getPrice(s));
        System.out.println("报价后操作");
    }

}
