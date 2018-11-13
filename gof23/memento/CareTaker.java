package gof23.memento;

/**
 * Created by admin on 2018/11/12.
 * 负责人类，负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
