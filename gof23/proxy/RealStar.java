package gof23.proxy;

/**
 * Created by admin on 2018/11/6.
 * 真实类
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("Real Star 面谈");
    }

    @Override
    public void signContract() {
        System.out.println("Real Star 签合同");
    }


    @Override
    public void bookTicket() {
        System.out.println("Real Star 订票");
    }

    @Override
    public void sing() {
        System.out.println("周杰伦本人唱歌");
    }

    @Override
    public void collectMoney() {
        System.out.println("Real Star 收钱");
    }
}
