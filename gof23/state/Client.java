package gof23.state;

/**
 * Created by admin on 2018/11/12.
 * 核心：用于解决系统中复杂对象的状态转换以及不同状态下行为的封装问题
 */
public class Client {
    public static void main(String[] args) {
        HomeContext context = new HomeContext();
        context.setState(new FreeState());
        context.setState(new CheckedState());
    }
}
