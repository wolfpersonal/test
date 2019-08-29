/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.dubbo;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import com.frxs.ocean.gateway.facade.OceanRequest;
import com.frxs.ocean.gateway.facade.OceanResponse;
import com.frxs.ocean.service.annotation.ClientBinding;
import com.frxs.ocean.service.request.ResponseCallBack;
import com.frxs.ocean.service.request.client.OceanClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lifeng.weng
 * @version OceanClientTest.java, v 1.0 2019年08月22日 10:00
 */
@Data
@Component("oceanClientTest")
public class OceanClientTest {



    @Autowired
    @ClientBinding(protocal = OceanProtocalEnum.DUBBO,retries = 1,timeout = 3000)
    private OceanClient client;

    public OceanResponse testRequest(OceanRequest request){
        return client.doRequest(request);
    }

    public OceanResponse testCall(OceanRequest request){
        client.call(request, new ResponseCallBack() {
            @Override
            public void onResponse(OceanResponse oceanResponse) {
                System.out.println(oceanResponse);
            }

        });
        return null;
    }

}