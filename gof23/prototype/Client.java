package gof23.prototype;

import java.util.Date;

/**
 * Created by admin on 2018/11/6.
 * 测试原型模式
 * 浅拷贝测试
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(123321L);
        Sheep shaoLi = new Sheep("少利", date);
        // 以少利为原型，在造一个羊 (浅拷贝)
        Sheep s = (Sheep) shaoLi.clone();
        System.out.println(shaoLi + " sname:" + shaoLi.getSname());
        System.out.println(shaoLi + " birthday:" + shaoLi.getBirthday());
        date.setTime(321321L);
        System.out.println("修改后的时间: " + date);
        System.out.println(s + " sname:" + s.getSname());
        System.out.println(s + " birthday:" + s.getBirthday());
    }
}
