/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.request.client.dubbo;


import com.frxs.framework.integration.dubbo.annotation.FrxsAutowired;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanRequestFacade;
import com.frxs.ocean.gateway.facade.OceanResponse;
import com.frxs.ocean.service.request.ResponseCallBack;
import com.frxs.ocean.service.request.client.AbstractOceanClient;
import com.frxs.ocean.service.request.client.OceanClient;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;


/**
 * @author lifeng.weng
 * @version DubboOceanClient.java, v 1.0 2019年08月09日 17:33
 */
@Data
@Service
public class DubboOceanClient extends AbstractOceanClient implements OceanClient {


    /** 指定异步执行的线程池大小*/
    private Executor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*2, Runtime.getRuntime().availableProcessors()*2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    @FrxsAutowired
    private OceanRequestFacade facade;


    @Override
    public OceanResponse doRequest(OceanRequest request) {
        return facade.doRequest(request);
    }

    @Override
    public void call(OceanRequest request, ResponseCallBack callBack) {

        // 异步执行
        CompletableFuture.runAsync(() -> {
            callBack.onResponse(facade.doRequest(request));
        },executor);
    }

    @Override
    public OceanResponse asyncCall(OceanRequest request) {
        return facade.asyncCall(request);
    }

}