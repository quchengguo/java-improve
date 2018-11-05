package gof23.factory.factorymethod;

import gof23.factory.simplefactory.Car;

/**
 * Created by admin on 2018/11/5.
 */
public class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();
        // 加个实现类
        Car c3 = new BenChiFactory().createCar();
        c1.run();
        c2.run();
    }
}
