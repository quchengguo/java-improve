package productConsume;

import java.util.List;

/*
 * ��������
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
			// remove��֮����Զ����б������ƶ�
		    int i =	pool.remove(); 
			System.out.println(name + "ȡ����: " + i);
		}
	}
}
