package gof23.observe;

/**
 * Created by admin on 2018/11/12.
 */
public class ObserverA implements Observer {
    // 跟目标对象的state值保持一致
    private int myState;

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject) subject).getState();
    }
}
