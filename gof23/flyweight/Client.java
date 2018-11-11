package gof23.flyweight;

/**
 * Created by admin on 2018/11/8.
 * 迪米特法则：一个软件实体应当尽可能少的与其他实体发生相互作用
 * 使用场景：线程池/数据库连接池/String类
 * 优点：减少相似对象的存储，公用一个对象
 * 缺点：使程序逻辑复杂化，分离出外部状态使外部程序运行时间长
 */
public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess);
        System.out.println(chess1);
        System.out.println("增加外部状态处理====");
        // 外部状态(Coordinate)需要传进来
        chess.display(new Coordinate(10, 10));
        chess1.display(new Coordinate(20, 20));
    }
}
