/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade;

import lombok.Data;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author lifeng.weng
 * @version OceanResponse.java, v 1.0 2019年08月09日 17:16
 */
@Data
public class OceanResponse implements Serializable {

    private static final long serialVersionUID = -6276083032697281157L;
    private ResponseStatus status;

    private String sign;

    private String message;

    private String bizId;

    private Map<String,Object> body;

}