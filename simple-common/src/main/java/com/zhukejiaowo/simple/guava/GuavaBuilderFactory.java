package com.zhukejiaowo.simple.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zhukejiaowo.simple.enums.GuavaKeyEnum;
import com.zhukejiaowo.simple.enums.GuavaStrategyEnum;
import com.zhukejiaowo.simple.utils.ArgsUtils;

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
public class GuavaBuilderFactory {

    public static Cache getCacheBuilder(GuavaKeyEnum guavaEnum) throws Exception{

        ArgsUtils.notNull(guavaEnum,"create guava builder");
        ArgsUtils.notNull(guavaEnum.getGuavaStrategyEnums(),"guava strategy");
        ArgsUtils.notNull(guavaEnum.getTimeUnit(),"guava timeunit");
        CacheBuilder<Object, Object> cacheBuilder  = CacheBuilder.newBuilder();
        GuavaStrategyEnum[] guavaStrategyEnums = guavaEnum.getGuavaStrategyEnums();
        for(GuavaStrategyEnum guavaStrategyEnum : guavaStrategyEnums){
            if(GuavaStrategyEnum.COUNT.name().equals(guavaStrategyEnum.name())){
                cacheBuilder.maximumSize(guavaEnum.getMaxSize());
            } else if (GuavaStrategyEnum.WRITE_EXPIRE.name().equals(guavaStrategyEnum.name())){
                cacheBuilder.expireAfterWrite(guavaEnum.getTimeInteval(),guavaEnum.getTimeUnit());
            } else if (GuavaStrategyEnum.ACCESS_EXPIRE.name().equals(guavaStrategyEnum.name())){
                cacheBuilder.expireAfterAccess(guavaEnum.getTimeInteval(),guavaEnum.getTimeUnit());
            } else if (GuavaStrategyEnum.WRITE_REFRESH.name().equals(guavaStrategyEnum.name())){
                cacheBuilder.refreshAfterWrite(guavaEnum.getTimeInteval(),guavaEnum.getTimeUnit());
            }
        }
        return cacheBuilder.build();
    }
}
