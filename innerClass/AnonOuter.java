package innerClass;

public class AnonOuter {
	public void method(){
		// ʵ��AnonInner�ӿ�
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
		
		// �����ڲ���,һ�д���㶨
		new AnonInner() {
			
			@Override
			public void function() {
				System.out.println("implements AnonInner function");
			}
		}.function();
	}
}
