package myThread;
/**
 * �Զ����߳���
 * @author cheng
 *
 */
public class ThreadOne extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(getName() + ": " + i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		// ��һ���̶ȲŻ�������
		System.out.println("������������");
	}
}
