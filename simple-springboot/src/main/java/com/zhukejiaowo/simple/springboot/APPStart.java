package com.zhukejiaowo.simple.springboot;

import com.zhukejiaowo.simple.springboot.config.SystemConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author caishang
 * @version V1.0
 * @Description: Springboot 启动类.
 * @date 2018/1/13
 */

/**
 * EnableScheduling:开启任务调度功能.
 * EnableConfigurationProperties:
 * SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan
 */
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties({SystemConfig.class})
public class APPStart {


}
