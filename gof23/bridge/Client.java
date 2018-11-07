package gof23.bridge;

/**
 * Created by admin on 2018/11/7.
 * 桥接测试
 * 桥接模式：连接多个模式，将每个维度单独的抽出来，在该例中为电脑和品牌。本质用组合代替继承
 */
public class Client {
    public static void main(String[] args) {
        // 用组合代替继承关系
        Computer2 computer = new LapTop2(new Lenovo());
        computer.sale();
        System.out.println("************");
        Computer2 shenZhouComputer = new DeskTop2(new Shenzhou());
        shenZhouComputer.sale();
    }
}