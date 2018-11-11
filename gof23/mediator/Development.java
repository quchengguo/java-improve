package gof23.mediator;

/**
 * Created by admin on 2018/11/10.
 */
public class Development implements Department {
    // 持有中介者(总经理)的引用
    private Mediator mediator;

    public Development(Mediator mediator) {
        super();
        this.mediator = mediator;
        mediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作！没钱了请求资源");
    }
}
