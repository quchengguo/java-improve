package com.study.zk;

import org.apache.zookeeper.*;

/**
 * Hello world!
 */
public class ZkDemo {
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("node1:2181,node2:2181", 30000, event -> {
            System.out.println("已经触发了" + event.getType() + "事件！");
            System.out.println("事件发生路径为:" + event.getPath());
            System.out.println("通知状态为:" + event.getState());
        });
//        zk.create("/mygril", "美丽的".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.getData("/mygril", true, null);
        zk.setData("/mygril", "善良的".getBytes(), -1);
        zk.close();
    }
}
