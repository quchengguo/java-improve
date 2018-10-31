package juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by admin on 2018/10/31.
 * 一、为什么要用线程池：防止频繁创建、释放浪费资源和时间
 * 二、线程池中提供了一个线程队列，队列中保存着所有等待状态的的线程
 * 三、线程池的体系结构：
 * java.util.concurrent.Executor:负责线程的使用与调度的根接口
 * |-- ExecutorService子接口：线程池的主要接口
 * |-- ThreadPoolExecutor 实现类
 * |-- ScheduledExecutorService 子接口:负责线程调度
 * |-- ScheduledThreadPoolExecutor:继承了ThreadPoolExecutor实现了ScheduledExecutorService，所以可以做线程池&调度
 * 四、工具类
 * ExecutorService newFixedThreadPool():创建固定大小的线程池
 * ExecutorService newCachedThreadPool():缓存线程池，线程池的大小不固定，可以根据需求自动的更改数量
 * ExecutorService newSingleThreadExecutor():创建单个线程，线程池中只有一个线程
 * ScheduledExecutorService newScheduledThreadPool():创建固定大小的线程池，还可以延迟和定时的执行任务
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        // 2.调度
        for (int i = 0; i < 10; i++) {
            Future<Integer> result =  pool.schedule(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int random = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" + random);
                    return random;
                }
            },3, TimeUnit.SECONDS);
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 3.关闭
        pool.shutdown();
    }
}
