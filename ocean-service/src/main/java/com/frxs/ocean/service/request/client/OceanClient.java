/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.request.client;


import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanResponse;
import com.frxs.ocean.service.request.ResponseCallBack;

/**
 * @author lifeng.weng
 * @version OceanClient.java, v 1.0 2019年08月09日 17:13
 */
public interface OceanClient {

    /**
     * 同步方法调用，需要等待立即返回结果
     * @param request
     * @return
     */
    OceanResponse doRequest(OceanRequest request);

    /**
     * 注册异步回调的方式
     * @param request
     * @return
     */
    void call(OceanRequest request, ResponseCallBack responseCallBack);

    /**
     * 网关异步通知的方式
     * @return
     */
    OceanResponse asyncCall(OceanRequest request);
}