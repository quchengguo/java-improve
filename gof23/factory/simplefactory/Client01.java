package gof23.factory.simplefactory;

/**
 * Created by admin on 2018/11/5.
 * 没有使用工厂时，client01要和Car接口、Audi、Byd打交道
 */
public class Client01 {
    public static void main(String[] args) {
        Car audi = new Audi();
        Car byd = new Byd();
        audi.run();
        byd.run();
    }
}
