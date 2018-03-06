package innerClass;

public class AnonOuter {
	public void method(){
		// 实现AnonInner接口
//		class inner implements AnonInner{
//
//			@Override
//			public void function() {
//				System.out.println("implements AnonInner function");
//			}
//			
//		}
//		inner i = new inner();
//		i.function();
		
		// 匿名内部类,一行代码搞定
		new AnonInner() {
			
			@Override
			public void function() {
				System.out.println("implements AnonInner function");
			}
		}.function();
	}
}
