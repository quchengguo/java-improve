package innerClass;

import innerClass.Outer.Inner;

/**
 * �ڲ���Ϊʲô�������
 * 
 * @author cheng
 *
 */
public class InnerMain {
	public static void main(String[] args) {

		// Inner i = new Outer().new Inner();
		// i.function();

		// static��Ա�ڲ���
		// Inner inner = new Outer.Inner();
		// inner.function();
		// Outer.Inner.function();

		// ����
		AnonOuter anonOuter = new AnonOuter();
		anonOuter.method();
	}
}
