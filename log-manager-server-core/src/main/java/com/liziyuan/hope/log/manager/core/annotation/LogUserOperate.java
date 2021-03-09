package com.liziyuan.hope.log.manager.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 打印用户操作信息
 * 类级别
 *
 * @author zqz
 * @version 1.0
 * @date 2020-11-17 14:04
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogUserOperate {
}
