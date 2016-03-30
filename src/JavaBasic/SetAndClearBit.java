package JavaBasic;

public class SetAndClearBit {
	static int a = 0;
	public static void main(String[] args) {
		a |= (1<<5); 	// | 按位或操作 ,双目运算符 a = a|(1<<5);
		System.out.println(a);
		a &= ~(1<<5);	// & 按位与操作，双目运算符， ~ 按位非操作，单目运算符
		System.out.println(a);
	}
}
