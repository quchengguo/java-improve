package gof23.factory.abstractfactory;

/**
 * Created by admin on 2018/11/5.
 */
public class Client {
    public static void main(String[] args) {
        CarFactory car = new LuxuryCarFactory();
        Engine engine = car.createEngine();
        engine.run();
        engine.start();
    }
}
