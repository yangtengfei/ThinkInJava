package _14;

import java.util.Random;

/**
 * 类字面常量
 * @author yangtf3
 *
 */
class Initable{
	static final int staticFinal = 47;	// static final定义的常量为编译器常量，不需要对类进行初始化就可以读取
	static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
	static {
		System.out.println("Init Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147; // 读取static定义的常量时，需要强制对类进行初始化
	static {
		System.out.println("Init Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;
	static {
		System.out.println("Init Initable3");
	}
}
public class ClassInitialization {
	public static Random random = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class.forName("Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
