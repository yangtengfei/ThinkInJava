package _20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 注解处理器
public class UserCaseTracker {
	public static void trackUseCase(List<Integer> useCase, Class<?> cl) {
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class); // getAnnotation返回指定类型的注解对象，如果指定的方法上
			if (uc != null) {                            // 没有该类型的注解，则返回null。
				System.out.println("Found Use Case:" + uc.id() + " " + uc.desc());
				useCase.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCase) {
			System.out.println("Warning: Missing use case-" + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCase = new ArrayList<Integer>();
		Collections.addAll(useCase, 47, 48, 49, 50);
		trackUseCase(useCase, PasswordUtils.class);
	}
}
