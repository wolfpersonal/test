/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.api.request.handler;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanResponse;


/**
 * 请求处理
 * @author lifeng.weng
 * @version Handler.java, v 1.0 2019年08月15日 16:38
 */
public interface Handler {

    /**
     * 同步的请求
     * @param request
     * @return
     */
    OceanResponse handlerRequest(OceanRequest request);

    /**
     * 异步回调的请求
     * @param request
     * @return
     */
    OceanResponse handlerAsyncRequest(OceanRequest request);


    /***
     *
     * @return
     */
    OceanProtocalEnum supportProtocal();
}
