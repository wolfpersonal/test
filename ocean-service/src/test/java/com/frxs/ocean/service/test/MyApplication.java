/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.domain.enums.PartnerProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.RequestParamter;
import com.frxs.ocean.service.dubbo.OceanClientTest;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifeng.weng
 * @version MyApplication.java, v 1.0 2019年08月14日 15:32
 */
@EnableApolloConfig(value = "application", order = 1)
@SpringBootApplication(scanBasePackages = {"com.frxs.ocean"})
@Configuration
@MapperScan(basePackages = {"com.frxs.ocean"})
public class MyApplication {



    public static void main(String[] args) {
        OceanClientTest clientTest = SpringApplication.run(MyApplication.class,args).getBean(OceanClientTest.class);
        OceanRequest oceanRequest = MockRequest();
        System.out.println(clientTest.testRequest(oceanRequest));
        clientTest.testCall(oceanRequest);
    }



    private static OceanRequest MockRequest() {
        OceanRequest oceanRequest = new OceanRequest();
        oceanRequest.setProtocal(OceanProtocalEnum.DUBBO);
        oceanRequest.setBizId("123456");
        oceanRequest.setRequestTime(System.currentTimeMillis());
        oceanRequest.setTraceId(1);
        RequestParamter requestParamter = new RequestParamter() ;
        requestParamter.setPartnerProtocal(PartnerProtocalEnum.HTTP);
        requestParamter.setSign("aaaaaa");
        Map<String,Object> map = new HashMap<>();
        map.put("username","wolf");
        map.put("address","岳麓大道");
        map.put("email","xiaowenginfo@126.com");
        requestParamter.setBizData(map);
        oceanRequest.setParameter(requestParamter);
        return oceanRequest;
    }
}