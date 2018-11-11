package gof23.chainofresp;

/**
 * Created by admin on 2018/11/10.
 * 原来这个叫做责任链模式，记得在之前有一个面试给我了题目：if{}else if{} else if{} 如何避免在新来条件时继续添加else if，现在这个责任链就可以很好地解决这个问题
 * 责任链模式测试
 * 使用场景：1.网关 2.servlet 过滤器 3.try ... catch
 * 参考资料：http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 */
public class Client {
    public static void main(String[] args) {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五");

        // 组织责任链对象的关系，这个可以写在配置文件中
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        // 开始请假操作
        LeaveRequest leaveRequest = new LeaveRequest("tom", 1, "回英国老家");
        director.handleRequest(leaveRequest);

    }
}