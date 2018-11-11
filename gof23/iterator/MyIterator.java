package gof23.iterator;

/**
 * Created by admin on 2018/11/10.
 * 自定义迭代器接口
 */
public interface MyIterator {
    // 将游标指向第一个元素
    void first();
    // 将游标指向下一个元素
    void next();
    // 判断是否存在下一个元素
    boolean hasNext();
    //
    boolean isFirst();
    boolean isLast();

    // 获取当前游标指向的对象
    Object getCurrentObj();
}
