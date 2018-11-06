package gof23.proxy;

/**
 * Created by admin on 2018/11/6.
 * 代理类
 */
public class ProxyStar implements Star {
    private Star realStar;

    public ProxyStar(Star star) {
        this.realStar = star;
    }

    @Override
    public void confer() {
        System.out.println("Proxy 面谈");
    }

    @Override
    public void signContract() {
        System.out.println("Proxy 签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("Proxy 订票");
    }

    @Override
    public void sing() {
        // 唱歌经纪人来不了，这个真来不了
        realStar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("Proxy 收钱");
    }
}
