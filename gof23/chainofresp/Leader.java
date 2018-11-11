package gof23.chainofresp;

/**
 * 抽象类
 * Created by admin on 2018/11/10.
 */
public abstract class Leader {
    protected String name;
    // 责任链模式的后继对象
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    // 设置责任链上的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);
}
