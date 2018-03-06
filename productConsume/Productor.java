package productConsume;

import java.util.List;

/**
 * ��������
 * @author cheng
 *
 */
public class Productor extends Thread{
	private String name;
	private Pool pool;
	public Productor() {}
	public Productor(String name, Pool pool) {
		this.name = name;
		this.pool = pool;
	}
	@Override
	public void run() {
		int i = 0; 
		while(true){
			// Ԫ��ֵ����100֮�����´�0��ʼ
			i = i > 100 ? 0 : i;
			pool.add(i++);
			System.out.println(name + "�������ˣ�" + i);
		}
	}
}
