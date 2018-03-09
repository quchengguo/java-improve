package JavaBean.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/** 
* @author quchengguo
* @version 2018��3��9�� ����3:18:59 
* �����л���student��д��student.txt
*/
public class OutpustObject {
	public static void main(String[] args) throws Exception{
		ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("student.txt"));
		
		Student stu = new Student("qu", "24");
		Student student = new Student("cheng", "25");
		List<Student> list = new ArrayList<Student>();
		
//		oop.writeObject(student);
//		oop.writeObject(stu);
		list.add(stu);
		list.add(student);
		oop.writeObject(list);
		oop.close();
	}
}
