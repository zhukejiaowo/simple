package com.zhukejiaowo.simple.log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Vector;

/**
 * Description:
 *
 * @author caishang9
 * @version 1.0.0
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/10  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */

public class Log4j2Test {

    private static  Logger log = LogManager.getLogger("log");

    public static void main(String[] args) throws  Exception{

        log.error("test start....");

        Vector<Thread> vectors=new Vector<Thread>();

        long startTime = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            Thread childrenThread= new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                        log.error("当前线程:{},j:{}.调用plus会员信息，来源:soa.vip,耗时:200ms,当前pin:zhukejiaoow,是否新用户:true,状态:4030,firstOpenDate:{},beginDate:{}"
                                ,new Object[]{Thread.currentThread().getName(),j,new Date(),new Date()});
                    }
                }
            });
            vectors.add(childrenThread);
            childrenThread.start();
        }
        //主线程
        for(Thread thread : vectors){
            thread.join(); //使用join来保证childrenThread的5个线程都执行完后，才执行主线程
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-startTime;
        log.error("总共耗时:{}",time);
        System.out.println("总共耗时:"+time+"ms");
        Thread.sleep(1000);
        log.error("整体结束。。。。。。。");
        System.out.println("整体结束。。。。。。。");
    }
}
