/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;

import com.frxs.ocean.domain.enums.OceanProtocalEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lifeng.weng
 * @version OceanRequest.java, v 1.0 2019年08月09日 9:42
 */
@Getter
@Setter
@ToString
public class OceanRequest implements Serializable {


    private static final long serialVersionUID = -8964859906249313376L;

    /** traceId，非必填，为了全链路跟踪，建议有的填上*/
    private long traceId;

    /** 请求的发起时间*/
    private long requestTime;

    /** 业务的唯一主键*/
    private String bizId;

    /** 合作方Id*/
    private int partnerId;

    /** 具体的apiId*/
    private int apiId;

    /** 请求参数*/
    private RequestParamter parameter;

    /** 当前的协议*/
    private OceanProtocalEnum protocal;



}