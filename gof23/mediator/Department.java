package gof23.mediator;

/**
 * Created by admin on 2018/11/10.
 * 同事类接口
 */
public interface Department {
    // 做本部门的申请
    void selfAction();

    // 向总经理提出申请
    void outAction();
}