package com.zhukejiaowo.simple.springboot.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author caishang
 * @version V1.0
 * @Description: TODO
 * @date 2018/1/13
 */
@Service
@Setter
@Getter
@ToString
@PropertySource(value="classpath:properties/system.properties")
public class SystemConfig {



}
