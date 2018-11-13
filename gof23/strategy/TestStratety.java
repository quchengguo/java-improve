package gof23.strategy;

/**
 * Created by admin on 2018/11/12.
 * 实现起来比较容易，符合一般开发人员的思路。加入条件特别多使整个代码难以维护不符合开闭原则
 */
public class TestStratety {
    public double getPrice(String type, double price) {
        if (type.equalsIgnoreCase("普通客户小批量")) {
            System.out.println("不打折原价");
            return price;
        } else if (type.equalsIgnoreCase("普通客户大批量")) {
            System.out.println("普通客户大批量,打九折");
            return price * 0.9;
        } else if (type.equalsIgnoreCase("老客户小批量")) {
            System.out.println("老客户小批量,打八五折");
            return price * 0.85;
        } else if (type.equalsIgnoreCase("老客户大批量")) {
            System.out.println("老客户大批量，打八折");
            return price * 0.8;
        }
        return price;
    }


}
