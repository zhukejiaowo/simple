package com.zhukejiaowo.simple.guava;

import com.google.common.cache.Cache;
import com.zhukejiaowo.simple.enums.GuavaKeyEnum;
import com.zhukejiaowo.simple.utils.ArgsUtils;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

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

public class GuavaCacheUtils implements GuavaCache {


    private static  Map<String,Cache> cacheBuilderMap = new ConcurrentHashMap<String,Cache>();

    private Object object = new Object();

    /**
     * 根据本地缓存获取，没有则从redis中获取.
     * @param k
     * @param guavaEnum
     * @param redisKey
     * @param <K>
     * @param <V>
     * @return
     * @throws Exception
     */
    @Override
    public <K, V> V getCacheValue(final K k, GuavaKeyEnum guavaEnum, String redisKey) throws Exception{
        ArgsUtils.notNull(guavaEnum,"guava enum");
        ArgsUtils.notBlank(guavaEnum.getPrefix(),guavaEnum.getPrefix());
        Cache<K,V> cache = null;
        if(null == cacheBuilderMap.get(guavaEnum.getPrefix())){
            synchronized (object){
              if(null == cacheBuilderMap.get(guavaEnum.getPrefix())){
                  cache =  GuavaBuilderFactory.getCacheBuilder(guavaEnum);
                  cacheBuilderMap.put(guavaEnum.getPrefix(),cache);
              }
            }
        }
        cache = cacheBuilderMap.get(guavaEnum.getPrefix());
        return cache.get(k, new Callable<V>() {
            @Override
            public V call() throws Exception {
                return null;
            }
        });
    }
}
