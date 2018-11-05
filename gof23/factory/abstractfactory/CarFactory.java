package gof23.factory.abstractfactory;

/**
 * Created by admin on 2018/11/5.
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}

