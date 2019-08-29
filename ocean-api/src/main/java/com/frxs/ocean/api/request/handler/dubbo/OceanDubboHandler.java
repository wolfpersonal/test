/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.handler.dubbo;

import com.frxs.ocean.api.request.handler.Handler;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanResponse;
import org.springframework.stereotype.Service;

/**
 * @author lifeng.weng
 * @version OceanDubboHandler.java, v 1.0 2019年08月15日 16:43
 */
@Service("oceanDubboHandler")
public class OceanDubboHandler implements Handler {


    @Override
    public OceanResponse handlerRequest(OceanRequest request) {
        OceanResponse oceanResponse = new OceanResponse();
        oceanResponse.setMessage("success");
        return oceanResponse;
    }

    @Override
    public OceanResponse handlerAsyncRequest(OceanRequest request) {
        return null;
    }

    @Override
    public OceanProtocalEnum supportProtocal() {
        return OceanProtocalEnum.DUBBO;
    }
}