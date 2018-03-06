package productConsume;

import java.util.List;

/**
 * 生产者类
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
			// 元素值超过100之后，重新从0开始
			i = i > 100 ? 0 : i;
			pool.add(i++);
			System.out.println(name + "生产出了：" + i);
		}
	}
}
