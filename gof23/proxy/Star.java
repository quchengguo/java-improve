package gof23.proxy;

/**
 * Created by admin on 2018/11/6.
 * 和客户直接打交道的接口
 */
public interface Star {
    /**
     * 面谈
     */
    void confer();

    /**
     * 签合同
     */
    void signContract();

    /**
     * 订票
     */
    void bookTicket();

    /**
     * 唱歌
     */
    void sing();

    /**
     * 收钱
     */
    void collectMoney();
}
