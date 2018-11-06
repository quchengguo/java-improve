package gof23.adapter;

/**
 * Created by admin on 2018/11/6.
 * 组合方式实现适配器
 */
public class Adaptor2 implements Target {
    Adaptee adaptee;
    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adaptor2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
