package gof23.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/11/12.
 * 如果玩游戏的话,这个相当于服务器
 */
public class Subject {
    protected List<Observer> list = new ArrayList<Observer>();

    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    public void removeObserver(Observer observer){
        list.remove(observer);
    }

    // 通知所有的观察者更新状态
    public void notifyAllObservers(){
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}
