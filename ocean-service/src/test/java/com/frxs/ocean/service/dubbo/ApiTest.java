///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.dubbo;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
//import com.frxs.ocean.domain.enums.OceanProtocalEnum;
//import com.frxs.ocean.domain.enums.PartnerProtocalEnum;
//import com.frxs.ocean.gateway.facade.OceanRequest;
//import com.frxs.ocean.gateway.facade.RequestParamter;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.Banner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.ApplicationPidFileWriter;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author lifeng.weng
// * @version ApiTest.java, v 1.0 2019年08月21日 19:18
// */
//@ComponentScan({"com.frxs"})
//@EnableApolloConfig
//@SpringBootConfiguration
//@Slf4j
//public class ApiTest {
//
//
//    @Reference
//    private OceanClientTest clientTest;
//
//    @Test
//    public void clientTest(){
//        OceanRequest oceanRequest = MockRequest();
//        System.out.println(clientTest.testRequest(oceanRequest));
//        clientTest.testCall(oceanRequest);
//    }
//
//
//
//    private static OceanRequest MockRequest() {
//        OceanRequest oceanRequest = new OceanRequest();
//        oceanRequest.setProtocal(OceanProtocalEnum.DUBBO);
//        oceanRequest.setBizId("123456");
//        oceanRequest.setRequestTime(System.currentTimeMillis());
//        oceanRequest.setTraceId(1);
//        RequestParamter requestParamter = new RequestParamter() ;
//        requestParamter.setPartnerProtocal(PartnerProtocalEnum.HTTP);
//        requestParamter.setSign("aaaaaa");
//        Map<String,Object> map = new HashMap<>();
//        map.put("username","wolf");
//        map.put("address","岳麓大道");
//        map.put("email","xiaowenginfo@126.com");
//        requestParamter.setBizData(map);
//        oceanRequest.setParameter(requestParamter);
//        return oceanRequest;
//    }
//}