package tickets;
/**
 * ���߳�ģ����Ʊ
 * ��100�Ż�Ʊ��ÿ��һ�ų�Ʊ��һ������Ʊ������С��1��ʱ��ֹͣ��Ʊ
 * @author cheng
 *
 */
public class TicketsMain {
	public static void main(String[] args) {
		// ֻ����һ��runnable����
		Saler s = new Saler();
		// ���������̶߳��󣬴���ͬ�Ĵ��� 
		Thread t = new Thread(s);
		t.setName("����һ");
		Thread t1 = new Thread(s);
		t1.setName("���ڶ�");
		Thread t2 = new Thread(s);
		t2.setName("������");
		
		t.start();
		t1.start();
		t2.start();
		
		// �ֽ�������ڷ����ʱ���ѧ��
//		Class ct1 = t1.getClass();
//		Class ct2 = t1.getClass();
//		System.out.println(ct1 == ct2); // true
//		System.out.println(ct1); // class java.lang.Thread
		
	}
}
