package myThread;
/**
 * �������̲߳�����
 * 1.�̳�thread��
 * 2.��дrun����
 * 3.�����Զ������
 * 4.start�����߳�
 * @author cheng
 *
 */
public class ThreadMain {
	public static void main(String[] args) {
		// ��һ��ʵ�ַ�ʽ���̳�thread
		// 1.���������߳�
//		ThreadOne threadOne = new ThreadOne();
//		ThreadOne threadTwo = new ThreadOne();
//		ThreadOne threadThree = new ThreadOne();
//		// 2.�����߳�����
//		threadOne.setName("one");
//		threadTwo.setName("two");
//		threadThree.setName("three");
//		// 3.�����߳�
//		threadOne.start();
//		threadTwo.start();
//		threadThree.start();
//		for(int i = 0; i < 10000000; i++){
			// ����finalize
//			new ThreadOne();
//		}
//		// ����ʵ��Thread
//		new Thread(){
//			@Override
//			public void run() {
//				System.out.println("start thread");
//			}
//		}.start();
//		System.out.println("��ǰ�߳�����"+Thread.activeCount()); 
		
		//////////////////////////////
		// �ڶ���ʵ�ַ�ʽ��ʵ��Runnable�ӿ�
//		ThreadRunnable t = new ThreadRunnable();
//		Thread thread = new Thread(t);
//		thread.start();
		// ʹ�������ڲ���ʵ��
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
		}).start();
//		
	}
}
