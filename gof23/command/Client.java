package gof23.command;

/**
 * Created by admin on 2018/11/12.
 * 命令模式测试
 * 应用场景：1.数据库事务的底层机制 2.命令的撤销和恢复
 * 可以在你执行命令的前后进行不同的操作
 */
public class Client {
    public static void main(String[] args) {
        // 1.封装命令
        Command command = new ConcreteCommand(new Receiver());

        // 2.发起命令
        Invoke invoke = new Invoke(command);
        invoke.call();
    }
}