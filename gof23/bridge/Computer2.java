package gof23.bridge;

/**
 * Created by admin on 2018/11/7.
 * 电脑类型维度
 */
public class Computer2 {
    protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}

class DeskTop2 extends Computer2 {

    public DeskTop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class LapTop2 extends Computer2 {

    public LapTop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}
