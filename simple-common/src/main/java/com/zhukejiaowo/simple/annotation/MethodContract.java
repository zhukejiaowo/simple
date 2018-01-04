package com.zhukejiaowo.simple.annotation;

import com.zhukejiaowo.simple.enums.ThreadingStateEnum;

import java.lang.annotation.*;

/**
 * Description:
 *      针对方法的新增或修改时协议的规范.
 * @author caishang9
 * @version 1.0.0
 *
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/4  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@Inherited()
public @interface MethodContract {

    ThreadingStateEnum threading() default ThreadingStateEnum.UNSAFE;
}
