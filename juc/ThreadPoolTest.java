package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 2.为线程池中的线程分配任务
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        for (int i = 0; i < 10; i++) {
            // 提交一次就开一个线程
            pool.submit(threadPoolDemo);
        }
        // 3.关闭线程池，shutdown比较平和，shutdownNow比较暴躁
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}