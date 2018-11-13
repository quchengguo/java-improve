package gof23.command;

/**
 * Created by admin on 2018/11/12.
 * 命令的调用者和发起者
 */
public class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call(){
        // 执行命令
        command.execute();
    }
}
