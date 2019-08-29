/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.context;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanRequestFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author lifeng.weng
 * @version FacadeTest.java, v 1.0 2019年08月19日 15:11
 */
@EnableAutoConfiguration
@Slf4j
public class FacadeTest {

    @Reference
    private OceanRequestFacade facade;

    public static void main(String[] args) {
        SpringApplication.run(FacadeTest.class);
    }


    @Bean
    public ApplicationRunner runner() {
        return args -> {
            System.out.println("facade :"+ facade);
            facade.doRequest(new OceanRequest());
            log.info("call facade successful...");
        };
    }
}