package gof23.factory.factorymethod;

import gof23.factory.simplefactory.Byd;
import gof23.factory.simplefactory.Car;

/**
 * Created by admin on 2018/11/5.
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
