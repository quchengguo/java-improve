package gof23.prototype;

import java.util.Date;

/**
 * Created by admin on 2018/11/6.
 * 原型模式
 * 深拷贝测试
 * 对于引用类型来说，深浅拷贝可以理解为值传递和引用传递
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(123321L);
        Sheep shaoLi = new Sheep("少利", date);
        // 以少利为原型，在造一个羊 (深拷贝)
        Sheep s = (Sheep) shaoLi.clone();
        System.out.println(shaoLi + " sname:" + shaoLi.getSname());
        System.out.println(shaoLi + " birthday:" + shaoLi.getBirthday());
        date.setTime(321321L);
        System.out.println("修改后的时间: " + date);
        System.out.println(s + " sname:" + s.getSname());
        System.out.println(s + " birthday:" + s.getBirthday());
    }
}