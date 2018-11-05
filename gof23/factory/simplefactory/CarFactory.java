package gof23.factory.simplefactory;

/**
 * Created by admin on 2018/11/5.
 * 简单工厂模式
 * 创建car的实现类对象
 * 缺点：没有满足OCP原则
 */
public class CarFactory {
    public static Car createCar(String type) {
        // 这里也不够灵活，还是没有足够的解耦，增加一个新的产品只能修改代码
        if ("奥迪".equalsIgnoreCase(type)) {
            return new Audi();
        } else if ("比亚迪".equalsIgnoreCase(type)) {
            return new Byd();
        } else {
            return null;
        }
    }
}
