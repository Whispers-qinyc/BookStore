package com.briup.bookstore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: SystemLog
 * @Description: 日志注解
 * @author: qinyc
 * @date: 2023/7/23 12:35
 * @version: v1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SystemLog {
    //接口功能介绍
    String businessName();
}