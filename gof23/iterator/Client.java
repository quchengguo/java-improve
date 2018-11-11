package gof23.iterator;

/**
 * Created by admin on 2018/11/10.
 * 迭代器测试
 * 应用场景：JDK内置的迭代器(List/Set)
 */
public class Client {
    public static void main(String[] args) {

        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");
        cma.addObject("dd");

        MyIterator iterator = cma.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}