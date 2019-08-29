/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.service.annotation;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;

import java.lang.annotation.*;

/**
 * @author lifeng.weng
 * @version ClientBinding.java, v 1.0 2019年08月14日 16:35
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface ClientBinding {

    /** 与第三方重试次数*/
    int retries() default 0;

    int timeout() default -1;

    /** 与网关的通讯协议*/
    OceanProtocalEnum protocal() default OceanProtocalEnum.DUBBO;
}