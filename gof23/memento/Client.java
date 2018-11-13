package gof23.memento;

/**
 * Created by admin on 2018/11/12.
 * 备忘录模式：把对象的属性保存在一个类中，当需要的时候在移过来
 * 使用场景：事务的回滚，ps中历史记录，悔棋操作也是备忘录
 */
public class Client {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Emp emp = new Emp("zhangsan", 18, 100);

        System.out.println("第一次创建对象:"+emp.toString());

        // 备忘一次
        careTaker.setMemento(emp.memento());
        emp.setAge(30);
        emp.setEname("wangwu");
        emp.setSalary(9000);

        System.out.println("第二次打印对象:" + emp.toString());
        // 恢复备忘录
        emp.recovery(careTaker.getMemento());
        System.out.print("第三次打印对象:" + emp.toString());
    }
}
