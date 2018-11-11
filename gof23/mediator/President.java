package gof23.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/11/10.
 * 总经理
 */
public class President implements Mediator {
    private Map<String, Department> map = new HashMap<String, Department>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname, department);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
