package productConsume;

import java.util.List;

/*
 * 消费者类
 */
public class Consume extends Thread{
	private String name;
	private Pool pool;
	public Consume() {	}
	public Consume(String name, Pool pool) {
		this.name = name;
		this.pool = pool;
	}
	@Override
	public void run() {
		while(true){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			// remove完之后会自动将列表向左移动
		    int i =	pool.remove(); 
			System.out.println(name + "取出了: " + i);
		}
	}
}
