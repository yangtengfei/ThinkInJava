package _20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义注解

@Target(ElementType.METHOD)  // 定义注解的使用场景，例如 一个方法、一个域等。
@Retention(RetentionPolicy.RUNTIME) // 定义注解在哪一个级别可用： SOURCE CLASS RUNTIME
public @interface Test {} // 没有元素的注解称为标记注解
