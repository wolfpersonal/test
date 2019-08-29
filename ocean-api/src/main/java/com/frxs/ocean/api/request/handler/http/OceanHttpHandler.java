/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.handler.http;

import com.frxs.ocean.api.request.handler.Handler;
import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lifeng.weng
 * @version OceanHttpHandler.java, v 1.0 2019年08月15日 16:38
 */
@Slf4j
@Service
public class OceanHttpHandler implements Handler {
    @Override
    public OceanResponse handlerRequest(OceanRequest request) {
        log.info("received an oceanRequest ,request is :%d",request);
        return null;
    }

    @Override
    public OceanResponse handlerAsyncRequest(OceanRequest request) {
        log.info("received an oceanRequest ,request is :%d",request);
        return null;
    }

    @Override
    public OceanProtocalEnum supportProtocal() {
        return OceanProtocalEnum.HTTP;
    }
}