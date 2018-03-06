package tickets;
/**
 * 多线程模拟售票
 * 有100张火车票，每售一张车票减一，当火车票的数量小于1的时候停止售票
 * @author cheng
 *
 */
public class TicketsMain {
	public static void main(String[] args) {
		// 只创建一个runnable对象
		Saler s = new Saler();
		// 创建三个线程对象，代表不同的窗口 
		Thread t = new Thread(s);
		t.setName("窗口一");
		Thread t1 = new Thread(s);
		t1.setName("窗口二");
		Thread t2 = new Thread(s);
		t2.setName("窗口三");
		
		t.start();
		t1.start();
		t2.start();
		
		// 字节码对象，在反射的时候会学到
//		Class ct1 = t1.getClass();
//		Class ct2 = t1.getClass();
//		System.out.println(ct1 == ct2); // true
//		System.out.println(ct1); // class java.lang.Thread
		
	}
}
