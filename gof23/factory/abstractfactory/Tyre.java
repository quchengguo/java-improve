package gof23.factory.abstractfactory;

/**
 * Created by admin on 2018/11/5.
 */
public interface Tyre {
    void revolve();
}
class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("转的快");
    }
}

class LowTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("转的慢");
    }
}
