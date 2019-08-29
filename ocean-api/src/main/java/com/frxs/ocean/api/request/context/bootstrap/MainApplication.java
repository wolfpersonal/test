/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.context.bootstrap;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lifeng.weng
 * @version MainApplication.java, v 1.0 2019年08月22日 19:53
 */
@EnableApolloConfig
@SpringBootApplication(scanBasePackages = {"com.frxs"})
@Slf4j
public class MainApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication app = new SpringApplication(MainApplication.class);
        ConfigurableApplicationContext context = null;
        try {
            context = app.run(args);
            context.addApplicationListener(new ApplicationPidFileWriter());
            log.info("服务启动成功");
        }catch(Throwable e){
            e.printStackTrace();

        }

    }
}