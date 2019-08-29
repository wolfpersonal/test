/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.filter.ip;

import com.alibaba.dubbo.rpc.*;

/**
 * 白名单过滤
 * @author lifeng.weng
 * @version BWIpFilter.java, v 1.0 2019年08月23日 14:15
 */
public class BWIpFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String clientIp = RpcContext.getContext().getRemoteHost();
        return null;
    }
}