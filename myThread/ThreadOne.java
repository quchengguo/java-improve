package myThread;
/**
 * 自定义线程类
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
		// 到一定程度才回收垃圾
		System.out.println("垃圾被清理了");
	}
}
