package com.zhukejiaowo.simple.guava;

import com.zhukejiaowo.simple.enums.GuavaStrategyEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author caishang9
 * @version 1.0.0
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/4  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */
@Setter
@Getter
@ToString
public class GuavaStrategy {

    private long maxSize = 1000;

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    private long timeInteval = 10;


    private GuavaStrategyEnum[] guavaStrategyEnums;


    public GuavaStrategy(long maxSize, TimeUnit timeUnit, long timeInteval, GuavaStrategyEnum[] guavaStrategyEnums) {
        this.maxSize = maxSize;
        this.timeUnit = timeUnit;
        this.timeInteval = timeInteval;
        this.guavaStrategyEnums = guavaStrategyEnums;
    }
}
