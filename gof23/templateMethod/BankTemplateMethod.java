package gof23.templateMethod;

/**
 * Created by admin on 2018/11/12.
 */
public abstract class BankTemplateMethod {
    // 具体方法
    public void takeNumber() {
        System.out.println("取号排队");
    }

    // 办理具体业务，钩子方法。子类可以重写这个方法
    public abstract void transact();

    public void evaluate() {
        System.out.println("反馈评分");
    }

    /**
     * final方法，代表这个方法不可以被子类的方法重写。如果你认为一个方法的功能已经足够完整了，可以将该方法申明为final
     * 模板方法
     */
    public final void process() {
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
