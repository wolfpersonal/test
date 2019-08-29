/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;

/**
 *
 * @author lifeng.weng
 * @version OceanRequestFacade.java, v 1.0 2019年08月15日 17:07
 */
public interface OceanRequestFacade {

    /**
     * 同步方法调用，需要等待立即返回结果
     * @param request
     * @return
     */
    OceanResponse doRequest(OceanRequest request);


    /**
     * 网关异步通知的方式
     * @return
     */
    OceanResponse asyncCall(OceanRequest request);
}