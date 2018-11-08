package gof23.decorator;

/**
 * Created by admin on 2018/11/8.
 * 装饰器模式：动态的为一个对象添加新的功能
 * 自我感觉也是使用组合
 * 应用场景：IO/Servlet API中request对象对应的HttpServletRequestWrapper/Strus2中request,response,session
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        System.out.println("----增加飞行功能");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();
        System.out.println("----增加水上游的功能");
        // 可以自由装配
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();
    }
}
