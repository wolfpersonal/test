/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;

/**
 * @author lifeng.weng
 * @version AsyncCallBack.java, v 1.0 2019年08月15日 11:33
 */
public interface AsyncCallBack {


    /**
     * 回调支持的协议，可扩展多协议支持
     *
     * @return
     */
    default OceanProtocalEnum[] supportProtocal() {
        return new OceanProtocalEnum[]{OceanProtocalEnum.DUBBO};
    }

    ;

    /**
     * 网关异步回调业务
     *
     * @param response
     * @return
     * @see ResponseStatus
     */
    ResponseStatus onAsyncCall(OceanResponse response);
}