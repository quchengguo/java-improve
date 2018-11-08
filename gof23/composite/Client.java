package gof23.composite;

/**
 * Created by admin on 2018/11/8.
 * 组合模式使用场景：GUI中的容器层次图/XML文件解析/JUnit单元测试框架
 * 组合模式适合处理树形结构，这里边有两个关键的概念：1.容器  2.叶子，容器中存放叶子节点
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f2, f3, f4, f5, f6;
        Folder f1 = new Folder("我的收藏");

        f2 = new ImageFile("老高的头像.jpg");
        f3 = new TextFile("hello.txt");
        f1.add(f2);
        f1.add(f3);

        f1.killVirus();
    }
}
