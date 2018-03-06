package productConsume;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者和消费者模式
 * 
 ************
 * 解决死锁方式：
 * 1.notifyAll()
 * 2.wait(1000); // 加时间片
 ************
 */
public class ProductAndConsume {
	public static void main(String[] args) {
		Pool pool = new Pool();
		Productor productor = new Productor("生产者", pool);
		Consume consume = new Consume("消费者", pool);
		Consume consume1 = new Consume("消费者1", pool);
//		Consume consume2 = new Consume("消费者2", pool);
		
		productor.start();
		consume.start();
		consume1.start();
//		consume2.start();
	}
}
