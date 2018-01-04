package com.zhukejiaowo.simple.enums;


/**
 * Description:
 *      处理本地缓存策略枚举.
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

public enum GuavaStrategyEnum {

    /**
     * 数量策略(LRU策略回收).
     */
    COUNT,

    /**
     * TTL 写入存活期失效策略.
     */
    WRITE_EXPIRE,

    /**
     * TTI 读写空闲期失效策略.
     */
    ACCESS_EXPIRE,

    /**
     * TTL 写入存活期刷新策略.
     */
    WRITE_REFRESH,




}
