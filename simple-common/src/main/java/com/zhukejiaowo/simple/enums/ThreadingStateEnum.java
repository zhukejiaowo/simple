package com.zhukejiaowo.simple.enums;

/**
 * Description:
 *      用来标识类或者方法的线程安全情况.
 * @author caishang9
 * @version 1.0.0
 *
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/4  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */
public enum ThreadingStateEnum {

    /**
     * 不可变且线程安全.
     */
    IMMUTABLE,

    /**
     * 线程安全.
     */
    SAFE,

    /**
     * 线程不安全.
     */
    UNSAFE,
    ;

}
