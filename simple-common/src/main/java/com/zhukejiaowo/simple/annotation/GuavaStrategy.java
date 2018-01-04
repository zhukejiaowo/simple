package com.zhukejiaowo.simple.annotation;


import com.zhukejiaowo.simple.enums.GuavaStrategyEnum;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *      处理本地缓存策略.
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
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GuavaStrategy {

    GuavaStrategyEnum[] guavaStrategys() default GuavaStrategyEnum.WRITE_EXPIRE;

    long maxSize() default 1000l;

    TimeUnit timeUnit() default  TimeUnit.SECONDS;

    long  timeInfo() default 10;

}
