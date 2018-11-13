package gof23.state;

/**
 * Created by admin on 2018/11/12.
 * 已预订状态类
 */
public class BookedState implements State{
    @Override
    public void handle() {
        System.out.println("房间已预定");
    }
}
