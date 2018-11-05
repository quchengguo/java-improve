package gof23.factory.factorymethod;

import gof23.factory.simplefactory.Audi;
import gof23.factory.simplefactory.Car;

/**
 * Created by admin on 2018/11/5.
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
