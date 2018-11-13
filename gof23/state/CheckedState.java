package gof23.state;

/**
 * Created by admin on 2018/11/12.
 * 已入住状态类
 */
public class CheckedState implements State{
    @Override
    public void handle() {
        System.out.println("房间已入住");
    }
}
