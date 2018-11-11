package gof23.chainofresp;

/**
 * Created by admin on 2018/11/10.
 * 主任类
 * 小于3天主任审批
 */
public class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 3){
            // 主任处理
            System.out.println("员工:" + request.getEmpName() + "请假，天数:" + request.getLeaveDays()+"理由:" + request.getReason());
            System.out.println("主任:" + this.name + "审批通过");
        }else {
            // 交给下一个审批者
            if(this.nextLeader != null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
