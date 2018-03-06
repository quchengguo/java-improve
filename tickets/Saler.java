package tickets;
/**
 * 售票类
 * @author cheng
 *
 */
public class Saler implements Runnable{
	// 锁旗标，被所有的对象共享
	Object lock = new Object();
	private int tickets = 100; 

	@Override
	public void run() {
			while(true){
				synchronized(lock){
					if(tickets < 1){
						System.out.println(Thread.currentThread().getName() + "票完了");
						return;
					}else{
						System.out.println(Thread.currentThread().getName() + ": " + tickets);
						tickets--;
					}
				}
			}
	}
}
