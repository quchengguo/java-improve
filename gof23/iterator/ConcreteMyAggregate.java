package gof23.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/11/10.
 * 自定义聚合类
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<Object>();

    public void addObject(Object obj) {
        list.add(obj);
    }

    public void removeObject(Object obj) {
        list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    // 获得迭代器
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    // 内部类，可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator {

        // 游标，用于记录遍历时的位置
        private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if (cursor < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0 ? true : false;
        }

        @Override
        public boolean isLast() {
            return cursor == (list.size() - 1) ? true : false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}