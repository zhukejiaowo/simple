package com.zhukejiaowo.simple.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zhukejiaowo.simple.enums.GuavaKeyEnum;
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
        return CacheBuilder.newBuilder().build();
    }
}
