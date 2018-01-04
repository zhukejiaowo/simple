package com.zhukejiaowo.simple.guava;


import com.zhukejiaowo.simple.enums.GuavaKeyEnum;

/**
 * Description:
 *      处理本地缓存策略.
 * @author caishang9
 * @version 1.0.0
 *
 */
public interface GuavaCache {

   public <K, V> V getCacheValue(final K k, GuavaKeyEnum guavaEnum, String redisKey) throws Exception;

}
