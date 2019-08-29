/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.Context;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author lifeng.weng
 * @version OceanContext.java, v 1.0 2019年08月23日 16:05
 */
public class OceanContext {

    protected static final ThreadLocal<OceanContext> LOCAL = new ThreadLocal<>();
    protected ConcurrentMap<String, Object> map = new ConcurrentHashMap();

    public static OceanContext getContext() {
        OceanContext context = (OceanContext)LOCAL.get();
        if (context == null) {
            context = new OceanContext();
            LOCAL.set(context);
        }

        return context;
    }


    public void put(String key, Object value) {
        if (key != null && value != null) {
            this.map.put(key, value);
        }

    }

    public Object get(String key) {
        return key != null ? this.map.get(key) : null;
    }

    public Object remove(String key) {
        return key != null ? this.map.remove(key) : null;
    }

    public static void removeContext() {
        LOCAL.remove();
    }
}