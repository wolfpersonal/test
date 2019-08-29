/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.gateway.facade.protocal.http;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import com.frxs.ocean.gateway.facade.protocal.ProtocalAttribute;

/**
 * @author lifeng.weng
 * @version HttpProtocalAttribute.java, v 1.0 2019年08月09日 13:45
 */
@Data
public class HttpProtocalAttribute extends ProtocalAttribute implements Serializable {
    private static final long serialVersionUID = -3183141350594173406L;

    private String host;

    private String uri;

    private int port;

    private Map<String,String> headers;
}