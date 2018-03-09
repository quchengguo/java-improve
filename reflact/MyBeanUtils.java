package JavaBean;

import java.lang.reflect.Field;
import java.util.Map;

/** 
* @author quchengguo
* @version 2018��3��9�� ����4:54:59 
* ʵ��BeanUtils�е�setProperty
*/
public class MyBeanUtils {
	private MyBeanUtils(){}
	
	/**
	 * ����bean������
	 * @param bean
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public static void setProperty(Object bean, String name, Object value) throws Exception{
		// 1.��ȡ�����ֽ������
		Class clazz = bean.getClass();
		// 2.ͨ����������ȡField����
		Field field = clazz.getDeclaredField(name);
		field.setAccessible(true);
		// 3.���ö���ֵ
		field.set(bean, value);
	}
	
	/**
	 * ��ȡbean����
	 * @return ��������Ӧ���ַ���
	 */
	public static String getProperty(Object bean, String name) throws Exception{
		Class clazz = bean.getClass();
		Field field = clazz.getDeclaredField(name);
		field.setAccessible(true);
		// ע��field.get�Ĳ���Ϊbean������������
		return  field.get(bean).toString();
	}
	/**
	 * ʹ��Map��bean���Ը�ֵ
	 * @param bean
	 * @param properties
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void populate(Object bean, Map properties) throws IllegalArgumentException, IllegalAccessException{
		Class clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			if(properties.containsKey(field.getName())){
				field.set(bean, properties.get(field.getName()));
			}
		}
	}
	
}
