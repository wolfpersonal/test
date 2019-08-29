/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frxs.ocean.api.request.handler.Handler;
import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanRequestFacade;
import com.frxs.ocean.gateway.facade.OceanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lifeng.weng
 * @version OceanRequestFacadeImpl.java, v 1.0 2019年08月15日 17:13
 */
@Slf4j
@Service
public class OceanRequestFacadeImpl implements OceanRequestFacade, InitializingBean {


    @Autowired
    private List<Handler> handlers;


    private Map<OceanProtocalEnum,Handler> handlerMap;


    @Override
    public OceanResponse doRequest(OceanRequest request) {
        log.info("received a sync request, request param is :{}",request);
        return handlerMap.get(request.getProtocal()).handlerRequest(request);
    }

    @Override
    public OceanResponse asyncCall(OceanRequest request) {
        return handlerMap.get(request.getProtocal()).handlerRequest(request);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        handlerMap = new HashMap<>(5);
        for(Handler handler : handlers){
            handlerMap.put(handler.supportProtocal(),handler);
        }

    }
}