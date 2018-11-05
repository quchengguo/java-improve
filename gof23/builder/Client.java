package gof23.builder;

/**
 * Created by admin on 2018/11/5.
 * 装配者-构建者测试
 */
public class Client {
    public static void main(String[] args) {
        // 1.获取到飞船的每个组件
        QcgAirShipDerector director = new QcgAirShipDerector(new QcgAirShipBuilder());
        // 2.组装飞船
        AirShip airShip = director.directAirShip();
        System.out.println(airShip.getEngine().getName());
        airShip.launch();
    }
}