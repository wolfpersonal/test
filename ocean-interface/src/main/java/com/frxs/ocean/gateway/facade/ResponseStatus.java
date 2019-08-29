/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;

/**
 * @author lifeng.weng
 * @version ResponseStatus.java, v 1.0 2019年08月15日 11:38
 */
public enum ResponseStatus {

    /** 已接收*/
    RECEIVED,
    /** 已成功*/
    SUCCEED,
    /** 已失败*/
    FAILED,
    /** 已超时*/
    TIMEOUT,
    /** 已被丢弃*/
    DISCARD,
    /** 已被中断*/
    INTERRUPT;
}
