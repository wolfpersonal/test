/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.context.bootstrap;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.frxs.ocean.api.request.facade.impl.OceanRequestFacadeImpl;
import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequestFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.Assert;

/**
 * @author lifeng.weng
 * @version ContextRunListener.java, v 1.0 2019年08月19日 11:00
 */
@Slf4j
public class ContextRunListener implements SpringApplicationRunListener {

    private String PROPERTIES_ZK_URL = "spring.dubbo.zkAddress";

    private String PROPERTIES_DUBBO_PORT = "spring.dubbo.protocolPort";



    public ContextRunListener(SpringApplication application, String[] param){
    }

    @Override
    public void starting() {
        log.info("context inited ...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        String zkUrl = context.getEnvironment().getProperty(PROPERTIES_ZK_URL);
        int dubboPort = Integer.valueOf(context.getEnvironment().getProperty(PROPERTIES_DUBBO_PORT));
        log.info("start to export provider, zk url is :{} , dubbo port is :{} ...",zkUrl,dubboPort);

        OceanRequestFacade bean = context.getBean(OceanRequestFacade.class);
        Assert.notNull(bean,"facade implements can not be null...");

        ServiceConfig<OceanRequestFacade> serviceConfig= new ServiceConfig<>();
        serviceConfig.setApplication(new ApplicationConfig(context.getId()));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://"+zkUrl));
        serviceConfig.setInterface(OceanRequestFacade.class);
        serviceConfig.setRef(context.getBean(OceanRequestFacade.class));
        serviceConfig.export();

    }



    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}