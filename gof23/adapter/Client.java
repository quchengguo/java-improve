package gof23.adapter;

/**
 * Created by admin on 2018/11/6.
 * 客户端类（笔记本  只有USB接口）
 * jdk中的使用场景：InputStreamReader字节字符流的相互转换
 */
public class Client {
    public static void test1(Target target) {
        target.handleReq();
    }

    public static void main(String[] args) {
//        test1(new Adaptor());
        // adapter2
        test1(new Adaptor2(new Adaptor()));
    }
}