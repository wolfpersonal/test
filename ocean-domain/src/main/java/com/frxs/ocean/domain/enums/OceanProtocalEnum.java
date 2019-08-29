/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.domain.enums;

/**
 * 网关内部通讯协议
 * @author lifeng.weng
 * @version OceanProtocalEnum.java, v 1.0 2019年08月09日 9:54
 */
public enum OceanProtocalEnum {

    DUBBO("dubbo"),
    HTTP("http"),
    HTTPS("https"),
    SMTP("smtp"),
    FTP("ftp"),
    UDP("udp");

    private String protocal ;

    private OceanProtocalEnum(String protocal){
        this.protocal = protocal;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
