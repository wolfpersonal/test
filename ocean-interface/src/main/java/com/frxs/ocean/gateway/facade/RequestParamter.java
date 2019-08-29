/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;


import com.frxs.ocean.domain.enums.PartnerProtocalEnum;

import com.frxs.ocean.gateway.facade.protocal.ProtocalAttribute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * @author lifeng.weng
 * @version RequestParamter.java, v 1.0 2019年08月09日 9:52
 */

@Getter
@Setter
@ToString
public class RequestParamter implements Serializable {

    private static final long serialVersionUID = 2027461758933218420L;

    /** 调用合作方的协议*/
    private PartnerProtocalEnum partnerProtocal;

    /** 合作方的签名*/
    private String sign;

    /** 请求协议相关属性*/
    private ProtocalAttribute protocalAttribute;

    /** 请求的实体数据*/
    private Map<String,Object> bizData;

}