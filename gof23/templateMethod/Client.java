package gof23.templateMethod;

/**
 * Created by admin on 2018/11/12.
 * 模板方法又称为钩子函数，方法回调
 * 使用场景：JUnit/Servlet doGet,doPost/spring中JDBCTemplate
 */
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        System.out.println("----");
        BankTemplateMethod btm1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        btm1.process();
    }
}

class DrawMoney extends BankTemplateMethod {

    // 抽象方法必须实现
    @Override
    public void transact() {
        System.out.println("我要取款");
    }
}