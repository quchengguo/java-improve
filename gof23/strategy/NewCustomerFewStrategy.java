package gof23.strategy;

/**
 * Created by admin on 2018/11/12.
 */
public class NewCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        // 这就相当于完成了一个if else 的执行
        System.out.println("普通用户小批量，不打折，原价");
        return standardPrice;
    }
}
