/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.request.client;

/**
 * @author lifeng.weng
 * @version AbstractOceanClient.java, v 1.0 2019年08月16日 9:56
 */
public abstract class AbstractOceanClient implements OceanClient {

    private int retries;

    private int readTimeout;

    private int connectTimeout;

    private void clientBind(int retries,int readTimeout,int connectTimeout){
        this.retries = retries;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }
}