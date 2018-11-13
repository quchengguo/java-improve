package gof23.observe2;

/**
 * Created by admin on 2018/11/12.
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者
        ObserverA observerA = new ObserverA();
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();

        // 添加到目标对象容器中
        subject.addObserver(observerA);
        subject.addObserver(observerA1);
        subject.addObserver(observerA2);

        subject.set(300);

        System.out.println(observerA.getMyState());
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());

        System.out.println("----状态修改了");
        subject.set(400);

        System.out.println(observerA.getMyState());
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
    }
}
