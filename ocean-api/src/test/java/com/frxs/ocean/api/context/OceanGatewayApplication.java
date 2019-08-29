/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.context;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author heaixia
 * @version : StoreMallApplication.java,v 0.1 2019年07月15日 11:29
 */
@EnableApolloConfig(value = "application", order = 1)
@SpringBootApplication(scanBasePackages = {"com.frxs"})
@Slf4j
public class OceanGatewayApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(OceanGatewayApplication.class, args);

    }
}