package gof23.mediator;

/**
 * Created by admin on 2018/11/10.
 */
public class Market implements Department {
    // 持有中介者(总经理)的引用
    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("汇报工作，项目承接的进度，需要资金支持！");
    }

    @Override
    public void outAction() {
        System.out.println("跑项目");
        // 这里实现了市场部和财务部交互
        mediator.command("finacial");
    }
}
