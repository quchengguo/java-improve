package gof23.observe;

/**
 * Created by admin on 2018/11/12.
 * 观察者模式-广播机制-消息订阅，网络游戏对战原理
 * 流程：把每一个观察者添加到list中，当主题发生了变化就更新所有的观察者
 * 使用场景：聊天室、网络游戏、servlet监听器
 */
public class Client {
    public static void main(String[] args) {
        // 目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 创建多个观察者
        ObserverA obs = new ObserverA();
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();

        // 添加到观察队伍中
        concreteSubject.registerObserver(obs);
        concreteSubject.registerObserver(obs1);
        concreteSubject.registerObserver(obs2);

        // 改变subject的状态
        concreteSubject.setState(3000);

        // 看看观察者的状态
        System.out.println(obs.getMyState());
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());

        System.out.println("----");
        // 改变subject的状态
        concreteSubject.setState(30);

        // 看看观察者的状态
        System.out.println(obs.getMyState());
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
    }
}
