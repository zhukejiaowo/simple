package com.zhukejiaowo.simple.enums;


import com.zhukejiaowo.simple.guava.GuavaStrategy;

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
public enum  GuavaKeyEnum {

//    @GuavaStrategy(guavaStrategys={GuavaStrategyEnum.ACCESS_EXPIRE,GuavaStrategyEnum.COUNT})
//    GUAVA_SOA_CONFIG("N_GUAVA_SOA_CONFIG",new GuavaStrategy(1000,TimeUnit.SECONDS,10,new GuavaStrategyEnum[]{GuavaStrategyEnum.COUNT,GuavaStrategyEnum.ACCESS_EXPIRE})),
        GUAVA_SOA_CONFIG("N_GUAVA_SOA_CONFIG",1000,TimeUnit.SECONDS,10,new GuavaStrategyEnum[]{GuavaStrategyEnum.COUNT,GuavaStrategyEnum.WRITE_EXPIRE});
    ;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 按照LRU策略最多的缓存数量.
     */
    private long maxSize;

    /**
     * 超时失效TTL/TTD 的维度.
     */
    private TimeUnit timeUnit;


    /**
     * 超时失效的时间间隔.
     */
    private long timeInteval;


    /**
     * guava回收策略.
     */
    private GuavaStrategyEnum[] guavaStrategyEnums;



    GuavaKeyEnum(String prefix, long maxSize, TimeUnit timeUnit, long timeInteval, GuavaStrategyEnum[] guavaStrategyEnums) {
        this.prefix = prefix;
        this.maxSize = maxSize;
        this.timeUnit = timeUnit;
        this.timeInteval = timeInteval;
        this.guavaStrategyEnums = guavaStrategyEnums;
    }

    public String getPrefix() {
        return prefix;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public long getTimeInteval() {
        return timeInteval;
    }

    public GuavaStrategyEnum[] getGuavaStrategyEnums() {
        return guavaStrategyEnums;
    }
}
