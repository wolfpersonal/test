/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.filter.ip;

/**
 * @author lifeng.weng
 * @version IPCheck.java, v 1.0 2019年08月23日 14:39
 */
public interface IPCheck {


    /**
     * 检查是否合法的应用IP
     * @param clientIP
     * @param appId
     * @return
     */
    public boolean isLegalAppIp(String clientIP,int appId);

    /**
     *
     * 检查是否合法的合作方IP
     * @param partnerIp
     * @param partnerId
     * @return
     */
    public boolean isLegalPartnerIp(String partnerIp,int partnerId);
}