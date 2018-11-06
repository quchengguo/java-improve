package gof23.prototype;

import java.io.*;
import java.util.Date;

/**
 * Created by admin on 2018/11/6.
 * 利用序列化和反序列化实现深拷贝
 */
public class Client3 {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Date date = new Date(123321L);
        Sheep shaoLi = new Sheep("少利", date);
        System.out.println(shaoLi + " sname:" + shaoLi.getSname());
        System.out.println(shaoLi + " birthday:" + shaoLi.getBirthday());


        // 利用序列化和反序列化实现深拷贝
        // 写出去
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(shaoLi);
        byte[] bytes = baos.toByteArray();
        // 读进来
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        // Sheep需要实现Serializable接口
        Sheep s = (Sheep) ois.readObject();
        date.setTime(321321L);
        System.out.println("修改后的时间: " + date);
        System.out.println(s + " sname:" + s.getSname());
        System.out.println(s + " birthday:" + s.getBirthday());
    }
}