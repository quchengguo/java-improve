package gof23.bridge;

/**
 * Created by admin on 2018/11/7.
 */
public interface Computer {
    void sale();
}

/**
 * 台式机
 */
class DeskTop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}

/**
 * 笔记本
 */
class LapTop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}

/**
 * 平板
 */
class Pad implements Computer {

    @Override
    public void sale() {
        System.out.println("销售平板");
    }
}

class LenovoDeskTop extends DeskTop {
    @Override
    public void sale() {
        System.out.println("销售联想台式机");
    }
}

class LenovoLapTop extends LapTop {
    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}

class LenovoPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售联想平板");
    }
}

class ShenzhouDeskTop extends DeskTop {
    @Override
    public void sale() {
        System.out.println("销售神州台式机");
    }
}

class ShenzhouLapTop extends LapTop {
    @Override
    public void sale() {
        System.out.println("销售神州笔记本");
    }
}

class ShenzhouPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售神州平板");
    }
}