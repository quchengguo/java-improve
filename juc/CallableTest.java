package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by admin on 2018/10/30.
 */
public class CallableTest {
    public static void main(String[] args) {
        CallableDemo cd = new CallableDemo();
        // 1.执行callable的方式需要futureTask的支持
        FutureTask<Integer> result = new FutureTask<Integer>(cd);
        new Thread(result).start();
        try {
            // 2.接受返回结果，须等待new Thread(result).start()执行完毕
            int sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer> {
    // 相对于runnable有返回值，有异常
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
