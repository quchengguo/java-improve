package gof23.mediator;

/**
 * Created by admin on 2018/11/10.
 * 测试中介者模式
 * 使用场景：房产中介
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();

        Market market = new Market(m);
        Development development = new Development(m);
        Finacial finacial = new Finacial(m);

        market.outAction();
    }
}
