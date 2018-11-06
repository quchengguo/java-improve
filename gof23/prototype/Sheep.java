package gof23.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/11/6.
 * 原型模式
 * Cloneable属于标签接口
 */
public class Sheep implements Cloneable,Serializable{
    private String sname;
    private Date birthday;

    public Sheep() {
    }

    public Sheep(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        // 添加如下代码实现深拷贝，本质上是对属性也进行复制
//        Sheep s = (Sheep) obj;
//        s.birthday = (Date) this.birthday.clone();
        return obj;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
