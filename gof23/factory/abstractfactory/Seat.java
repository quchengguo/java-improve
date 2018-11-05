package gof23.factory.abstractfactory;

/**
 * Created by admin on 2018/11/5.
 */
public interface Seat {
    void massage();
}
class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("可以按摩");
    }
}
class LowSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("不能按摩");
    }
}
