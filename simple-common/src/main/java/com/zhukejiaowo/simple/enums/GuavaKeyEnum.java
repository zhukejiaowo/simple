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
    GUAVA_SOA_CONFIG("N_GUAVA_SOA_CONFIG",new GuavaStrategy(1000,TimeUnit.SECONDS,10,new GuavaStrategyEnum[]{GuavaStrategyEnum.COUNT,GuavaStrategyEnum.ACCESS_EXPIRE})),

    ;

    /**
     * 前缀
     */
    private String prefix;

    private GuavaStrategy guavaStrategy;



    GuavaKeyEnum(String prefix,GuavaStrategy guavaStrategy){
        this.prefix = prefix;
        this.guavaStrategy = guavaStrategy;
    }

    public String getPrefix() {
        return prefix;
    }

    public GuavaStrategy getGuavaStrategy() {
        return guavaStrategy;
    }
}
