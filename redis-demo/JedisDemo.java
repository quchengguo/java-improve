package com.study;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by quchengguo on 2018/7/9.
 * Jedis常用API
 * redis支持5中数据类型：
 * 1.字符串(strings)
 * 2.散列(hashes)
 * 3.列表(lists)
 * 4.集合(sets)
 * 5.有序集合(sorted sets)
 */
public class JedisDemo {

    private static ShardedJedisPool shardedJedisPool;

    // 静态代码初始化池配置
    static {
        //change "maxActive" -> "maxTotal" and "maxWait" -> "maxWaitMillis" in all examples
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setMaxTotal(-1);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(5);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        //创建四个redis服务实例，并封装在list中
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(new JedisShardInfo("localhost", 6379));
        //创建具有分片功能的的Jedis连接池
        shardedJedisPool = new ShardedJedisPool(config, list);
    }

    public static ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public static ShardedJedis getResource() {
        return shardedJedisPool.getResource();
    }

    public static void main(String[] args) {
        ShardedJedis jedis = JedisDemo.getShardedJedisPool().getResource();
        // 1.string操作
        jedis.set("string-name", "quchengguo");
        String stringName = jedis.get("string-name");
        System.out.println(stringName);
        // 2.hash操作，hash特别适合存储对象
        jedis.hset("person", "name", "lzl");
        jedis.hset("person", "age", "23");
        jedis.hset("person", "address", "河南");
        jedis.hset("person", "birthday", "1993-01-01");
        jedis.hset("person", "price", "2.3");
        // 2.1获取key中所有的属性
        System.out.println("person对象对应的属性有:"+jedis.hkeys("person"));
        // 2.2获取hash表中指定key的所有字段和值
        System.out.println("person对象的属性和值分别是："+jedis.hgetAll("person"));
        // 3.list操作
        jedis.rpush("lkeys", "val1","val2","val1","val1","val2","val3","val4","val5");
        // 获取list指定区域的值
        System.out.println(jedis.lrange("lkeys", 0, 20));
        // 4.set操作
        jedis.sadd("skeys", "sval1","sval2","sval3","sval4","sval5");
        jedis.sadd("skeys_l", "sval1","sval6","sval7","sval4","sval5");
        System.out.println("获取集合的成员数:"+jedis.scard("skeys"));
        // 5.sortset操作
        
    }
}
