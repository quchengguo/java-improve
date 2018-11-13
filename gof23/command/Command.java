package gof23.command;

/**
 * Created by admin on 2018/11/12.
 */
public interface Command {
    /**
     * 执行命令
     */
    void execute();
}
class ConcreteCommand implements Command{

    // 执行者的引用
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 调用真正的执行
        receiver.action();
    }
}
