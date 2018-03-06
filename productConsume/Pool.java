package productConsume;

import java.util.ArrayList;
import java.util.List;

/** 
* @author quchengguo
* @version 2018��3��6�� ����9:04:43 
* ������-������ �м����
* ע�⣺
* 1.������������ʱ��ѭ���ȴ���wait��
* 2.ÿ����ӻ���ɾ����Ԫ�ض�notify�����ѣ�һ���߳�
*/
public class Pool {
	private List<Integer> list = new ArrayList<Integer>();
	// �������ֵ
	private static final int MAX = 100; 
	
	// ����Ԫ��
	public void add(int num){
		synchronized(this){
			// ���Ԫ�س���100�̵߳ȴ�
				try {
					while(list.size() >= MAX){
						// wait������������ĵȴ����У��ͷ�cpu����ռȨ���ͷ������ļ��Ȩ
						// notify���Ի��ѵȴ������е��̣߳������һ����
						this.wait();
					}
					list.add(num);
					System.out.println("size: " + list.size());
					this.notify();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
	// ɾ��Ԫ��
	public int remove(){
		synchronized (this) {
			try {
				while(list.size() == 0){
					this.wait();
				}
				int i = list.remove(0);
				this.notify();
				return i;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
	}
}
