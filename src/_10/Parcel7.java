package _10;

public class Parcel7 {
	public Contents contents() {
		return new Contents() { // 插入一个类的定义
			private int i = 11;
			@Override
			public int value() {return i;}
		};
	}
	
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
		System.out.println(c.value());
	}
}
