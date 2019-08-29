/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.filter.ip.impl;

import com.frxs.ocean.core.filter.ip.IPCheck;

/**
 * @author lifeng.weng
 * @version IPCheckServiceImpl.java, v 1.0 2019年08月23日 14:44
 */
public class IPCheckImpl implements IPCheck {


    @Override
    public boolean isLegalAppIp(String clientIP, int appId) {
        return true;
    }

    @Override
    public boolean isLegalPartnerIp(String partnerIp, int partnerId) {
        return true;
    }
}