package innerClass;

public class Outer {
	private static int num = 10;
	
	// 成员内部类
	static class Inner{
		public static void function(){
			System.out.println("inner function " + num);
//			method();
		}
	}
	public void method(){
		System.out.println("Outer - method");
	}
}
