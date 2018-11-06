package gof23.adapter;

/**
 * Created by admin on 2018/11/6.
 * 适配器本身(转接器)
 * 继承方式
 */
public class Adaptor extends  Adaptee implements Target {
    @Override
    public void handleReq() {
        super.request();
    }
}
