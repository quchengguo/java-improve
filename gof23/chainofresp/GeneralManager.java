package gof23.chainofresp;

/**
 * Created by admin on 2018/11/10.
 * 总经理
 */
public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 30){
            // 经理
            System.out.println("员工:" + request.getEmpName() + "请假，天数:" + request.getLeaveDays()+"理由:" + request.getReason());
            System.out.println("总经理:" + this.name + "审批通过");
        }else {
            // 总经理是终结者，不交给下一个审批者
            System.out.println("莫非:" + request.getEmpName() + "想辞职？居然请假" + request.getLeaveDays() + "天");
        }
    }
}
