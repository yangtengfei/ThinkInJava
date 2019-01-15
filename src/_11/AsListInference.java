package _11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new D(), new E(), new A());
		
		List<Snow> snow2 = Arrays.asList(new B(), new C());
		
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new B(), new C());
		
		List<Snow> snow4 = Arrays.<Snow>asList(new B(), new C()); // <Snow> 显式类型参数说明
		
		System.out.println(snow1);
		System.out.println(snow2);
		System.out.println(snow3);
		System.out.println(snow4);
	}
}

class Snow{}
class A extends Snow{}
class B extends Snow{}
class C extends Snow{}
class D extends Snow{}
class E extends Snow{}
