package innerClass;

import innerClass.Outer.Inner;

/**
 * 内部类为什么会产生？
 * 
 * @author cheng
 *
 */
public class InnerMain {
	public static void main(String[] args) {

		// Inner i = new Outer().new Inner();
		// i.function();

		// static成员内部类
		// Inner inner = new Outer.Inner();
		// inner.function();
		// Outer.Inner.function();

		// 匿名
		AnonOuter anonOuter = new AnonOuter();
		anonOuter.method();
	}
}
