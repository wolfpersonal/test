/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.filter.idemopotent;

/**
 * @author lifeng.weng
 * @version IdemopotentCheck.java, v 1.0 2019年08月23日 14:59
 */
public interface IdemopotentCheck {

    /**
     * 业务接口调用幂等性检查
     * @param bizId 业务唯一标识
     * @param appId appId
     * @param apiId 具体的apiId
     */
    public void checkIdemopotent(String bizId ,int appId,int apiId);
}