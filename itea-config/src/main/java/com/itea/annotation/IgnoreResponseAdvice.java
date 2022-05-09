package com.itea.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: cy
 * @Description:  不需要统一返回结果的地方，使用该注解
 * @Date 14:59 2022/5/7
 */
@Target({ElementType.TYPE,ElementType.METHOD}) //元注解，表示作用在类和方法上，即class和method上
@Retention(RetentionPolicy.RUNTIME) //作用生效阶段，一直到编译源码都有效
public @interface IgnoreResponseAdvice {
}
