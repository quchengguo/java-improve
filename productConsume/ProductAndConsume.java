package productConsume;

import java.util.ArrayList;
import java.util.List;

/**
 * �����ߺ�������ģʽ
 * 
 ************
 * ���������ʽ��
 * 1.notifyAll()
 * 2.wait(1000); // ��ʱ��Ƭ
 ************
 */
public class ProductAndConsume {
	public static void main(String[] args) {
		Pool pool = new Pool();
		Productor productor = new Productor("������", pool);
		Consume consume = new Consume("������", pool);
		Consume consume1 = new Consume("������1", pool);
//		Consume consume2 = new Consume("������2", pool);
		
		productor.start();
		consume.start();
		consume1.start();
//		consume2.start();
	}
}
