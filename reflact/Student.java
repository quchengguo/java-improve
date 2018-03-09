package JavaBean;
/** 
* @author quchengguo
* @version 2018年3月8日 上午9:40:32 
*/
public class Student {
	private String name;
	private String age;
	public Student(){}
	public Student(String name, String age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
