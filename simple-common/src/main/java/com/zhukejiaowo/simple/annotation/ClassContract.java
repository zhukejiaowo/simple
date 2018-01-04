package com.zhukejiaowo.simple.annotation;

import com.zhukejiaowo.simple.enums.ThreadingStateEnum;

import java.lang.annotation.*;

/**
 * Description:
 *      用于描述类修改或者新增时的协议.
 * @author caishang9
 * @version 1.0.0
 *
 *
 *
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/4  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ClassContract {

    ThreadingStateEnum threading() default  ThreadingStateEnum.UNSAFE;
}
