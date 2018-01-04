package com.zhukejiaowo.simple.guava;

import com.google.common.cache.CacheBuilder;
import com.zhukejiaowo.simple.annotation.GuavaStrategy;
import com.zhukejiaowo.simple.enums.GuavaStrategyEnum;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

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
@SupportedAnnotationTypes(value = GuavaProcessor.annotationType)
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class GuavaProcessor extends AbstractProcessor {

    protected static final String annotationType = "com.zhukejiaowo.simple.annotation.GuavaStrategy";


    private CacheBuilder cacheBuilder;


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {

        for (Element annotatedElement : env.getElementsAnnotatedWith(GuavaStrategy.class)) {
            // 检查被注解为@GuavaStrategy的元素是否是一个类
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                return true; // 退出处理
            }

            //解析，并生成代码
            GuavaStrategy guavaStrategy = annotatedElement.getAnnotation(GuavaStrategy.class);
            GuavaStrategyEnum[] guavaStrategyEnums = guavaStrategy.guavaStrategys();
            

        }


        return false;

    }
}
