package gof23.state;

/**
 * Created by admin on 2018/11/12.
 * 空闲状态类
 */
public class FreeState implements State{
    @Override
    public void handle() {
        System.out.println("房间空闲没人住！！");
    }
}
