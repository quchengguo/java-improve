package JavaBean.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/** 
* @author quchengguo
* @version 2018年3月9日 下午3:18:27 
* 读取数组中序列化的student
*/
public class SerializableMain {

	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
		
		ArrayList<Student> arrList = (ArrayList) ois.readObject();
		
		Iterator<Student> iterator = arrList.iterator();
		while(iterator.hasNext()){
		    Student stu = iterator.next();
		    System.out.println(stu);
		}
		
		ois.close();
	}

}
