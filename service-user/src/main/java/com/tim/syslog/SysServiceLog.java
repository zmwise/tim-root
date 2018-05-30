package com.tim.syslog;

import java.lang.annotation.*;

/**
 * @description: 自定义注解 拦截service
 * @auther: lizhiming
 * @date: 2018/4/20 15:50
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysServiceLog {
    String desc() default "";
}
