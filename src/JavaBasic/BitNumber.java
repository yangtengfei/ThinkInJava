package JavaBasic;

public class BitNumber {
//	static int a = 0;
//	static int b = 32;
	public static void main(String[] args) {
		int[] array = new int[4];
		for (int i = 0; i < array.length; i++) {
			array[i] = 16;
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] >> 4;
			System.out.println(array[i]);
		}
		System.out.println(100&31);
		System.out.println(100&0x1F);
//		a |= (1<<5);   // | 按位或操作  a = a|(1<<5);
//		System.out.println(a);
//		System.out.println(a ^= b);	// ^ 按位异或
//		b &= a;			// 按位 与
//		System.out.println(b);
	}
}
