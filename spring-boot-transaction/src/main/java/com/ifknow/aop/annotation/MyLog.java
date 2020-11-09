package com.ifknow.aop.annotation;

import java.lang.annotation.*;

/**
 * @author: GongShiYong <br>
 * @date: 2020/11/9  14:46 <br>
 * @description: NO Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    /**
     * 用户操作哪个模块
     */
    String title() default "";

    /**
     * 记录用户操作的动作
     */
    String action() default "";
}
