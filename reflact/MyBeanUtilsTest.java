package JavaBean;

import java.lang.reflect.Method;

/** 
* @author quchengguo
* @version 2018��3��9�� ����4:39:14 
* ʵ��BeanUtils��setProperty����
*/
public class SetPropertyImpl {

	public static void main(String[] args) throws Exception{
		Student student = new Student();
		MyBeanUtils.setProperty(student, "name", "zhaolei");
		MyBeanUtils.setProperty(student, "age", "30");
//		System.out.println(student);
		String name = MyBeanUtils.getProperty(student, "name");
		System.out.println(name);
	}
}
