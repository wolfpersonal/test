/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.request;

import com.frxs.ocean.gateway.facade.OceanResponse;

/**
 * @author lifeng.weng
 * @version ResponseCallBack.java, v 1.0 2019年08月21日 14:25
 */
public interface ResponseCallBack {

    public void onResponse(OceanResponse oceanResponse);

}