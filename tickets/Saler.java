package tickets;
/**
 * ��Ʊ��
 * @author cheng
 *
 */
public class Saler implements Runnable{
	// ����꣬�����еĶ�����
	Object lock = new Object();
	private int tickets = 100; 

	@Override
	public void run() {
			while(true){
				synchronized(lock){
					if(tickets < 1){
						System.out.println(Thread.currentThread().getName() + "Ʊ����");
						return;
					}else{
						System.out.println(Thread.currentThread().getName() + ": " + tickets);
						tickets--;
					}
				}
			}
	}
}
