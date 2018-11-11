package gof23.mediator;

/**
 * Created by admin on 2018/11/10.
 */
public interface Mediator {
    void register(String dname, Department department);

    void command(String dname);
}
