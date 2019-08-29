/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.filter.idemopotent;

import com.alibaba.dubbo.rpc.*;

/**
 * 幂等性检查
 * @author lifeng.weng
 * @version IdemopotentFilter.java, v 1.0 2019年08月23日 14:56
 */
public class IdemopotentFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return null;
    }
}
