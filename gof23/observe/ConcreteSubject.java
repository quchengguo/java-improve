package gof23.observe;

/**
 * Created by admin on 2018/11/12.
 * 具体的主题对象
 */
public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 主题（目标）对象发生了变化通知所有的观察者
        this.notifyAllObservers();
    }
}
