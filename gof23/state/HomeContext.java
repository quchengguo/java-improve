package gof23.state;

/**
 * Created by admin on 2018/11/12.
 * 标记程序处于哪个状态
 */
public class HomeContext {
    private State state;

    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        this.state.handle();
    }
}
