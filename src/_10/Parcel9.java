package _10;

public class Parcel9 {
	public Destination destination(final String dest) { // Java8 默认把String dest 设置为final,Java5中没有所以此处加final
		return new Destination() {
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("abc");
		System.out.println(d.readLabel());
	}
}
