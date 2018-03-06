package myThread;
/**
 * 创建多线程并启动
 * 1.继承thread类
 * 2.重写run方法
 * 3.创建自定义对象
 * 4.start启动线程
 * @author cheng
 *
 */
public class ThreadMain {
	public static void main(String[] args) {
		// 第一种实现方式：继承thread
		// 1.创建三个线程
//		ThreadOne threadOne = new ThreadOne();
//		ThreadOne threadTwo = new ThreadOne();
//		ThreadOne threadThree = new ThreadOne();
//		// 2.设置线程名字
//		threadOne.setName("one");
//		threadTwo.setName("two");
//		threadThree.setName("three");
//		// 3.启动线程
//		threadOne.start();
//		threadTwo.start();
//		threadThree.start();
//		for(int i = 0; i < 10000000; i++){
			// 测试finalize
//			new ThreadOne();
//		}
//		// 匿名实现Thread
//		new Thread(){
//			@Override
//			public void run() {
//				System.out.println("start thread");
//			}
//		}.start();
//		System.out.println("当前线程数："+Thread.activeCount()); 
		
		//////////////////////////////
		// 第二种实现方式：实现Runnable接口
//		ThreadRunnable t = new ThreadRunnable();
//		Thread thread = new Thread(t);
//		thread.start();
		// 使用匿名内部类实现
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
