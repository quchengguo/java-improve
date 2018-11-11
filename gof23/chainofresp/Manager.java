package gof23.chainofresp;

/**
 * Created by admin on 2018/11/10.
 * 经理
 * 大于等于3天小于10天经理审批
 */
public class Manager extends Leader{
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 10){
            // 经理
            System.out.println("员工:" + request.getEmpName() + "请假，天数:" + request.getLeaveDays()+"理由:" + request.getReason());
            System.out.println("经理:" + this.name + "审批通过");
        }else {
            // 交给下一个审批者
            if(this.nextLeader != null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
