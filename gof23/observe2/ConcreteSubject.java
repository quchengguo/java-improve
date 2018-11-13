package gof23.observe2;

import java.util.Observable;

/**
 * Created by admin on 2018/11/12.
 * 目标对象
 */
public class ConcreteSubject extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void set(int state) {
        this.state = state;
        // 表示目标对象发生了改变
        setChanged();
        // 通知所有的观察者
        notifyObservers(state);
    }
}
