package com.zhukejiaowo.simple.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caishang
 * @version V1.0
 * @Description: TODO
 * @date 2018/1/13
 */
@RestController
@EnableAutoConfiguration
public class SimpleController {

    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Value("${about}")
    private String about;

    @RequestMapping("/")
    public String changeMySelf(){
        logger.error("you must do it.");
        return "what shawn is not ." + about;
    }

    public static void main(String[] args){
        SpringApplication.run(SimpleController.class);
    }
}
