package productConsume;

import java.util.ArrayList;
import java.util.List;

/** 
* @author quchengguo
* @version 2018年3月6日 下午9:04:43 
* 生产者-消费者 中间介质
* 注意：
* 1.当不满足条件时，循环等待（wait）
* 2.每次添加或者删除完元素都notify（唤醒）一下线程
*/
public class Pool {
	private List<Integer> list = new ArrayList<Integer>();
	// 容器最大值
	private static final int MAX = 100; 
	
	// 增加元素
	public void add(int num){
		synchronized(this){
			// 如果元素超过100线程等待
				try {
					while(list.size() >= MAX){
						// wait进入锁旗标对象的等待队列，释放cpu的抢占权，释放锁旗标的监控权
						// notify可以唤醒等待队列中的线程（随机挑一个）
						this.wait();
					}
					list.add(num);
					System.out.println("size: " + list.size());
					this.notify();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
	// 删除元素
	public int remove(){
		synchronized (this) {
			try {
				while(list.size() == 0){
					this.wait();
				}
				int i = list.remove(0);
				this.notify();
				return i;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
	}
}
