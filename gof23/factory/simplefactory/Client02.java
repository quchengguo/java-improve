package gof23.factory.simplefactory;

/**
 * Created by admin on 2018/11/5.
 * 使用工厂类
 * Client02只和工厂类和Car接口 打交道
 */
public class Client02 {
    public static void main(String[] args) {
        Car audi = CarFactory.createCar("奥迪");
        Car byd = CarFactory.createCar("比亚迪");
        audi.run();
        byd.run();
    }
}
