package JavaBean;

import java.lang.reflect.Field;
import java.util.Map;

/** 
* @author quchengguo
* @version 2018年3月9日 下午4:54:59 
* 实现BeanUtils中的setProperty
*/
public class MyBeanUtils {
	private MyBeanUtils(){}
	
	/**
	 * 设置bean的属性
	 * @param bean
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public static void setProperty(Object bean, String name, Object value) throws Exception{
		// 1.获取对象字节码对象
		Class clazz = bean.getClass();
		// 2.通过属性名获取Field对象
		Field field = clazz.getDeclaredField(name);
		field.setAccessible(true);
		// 3.给该对象赋值
		field.set(bean, value);
	}
	
	/**
	 * 获取bean属性
	 * @return 属性所对应的字符串
	 */
	public static String getProperty(Object bean, String name) throws Exception{
		Class clazz = bean.getClass();
		Field field = clazz.getDeclaredField(name);
		field.setAccessible(true);
		// 注意field.get的参数为bean而不是属性名
		return  field.get(bean).toString();
	}
	/**
	 * 使用Map给bean属性赋值
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
