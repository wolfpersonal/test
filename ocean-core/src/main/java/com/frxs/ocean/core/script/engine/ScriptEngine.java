/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.script.engine;

/**
 * 脚本解析引擎
 * @author lifeng.weng
 * @version ScriptEngine.java, v 1.0 2019年08月10日 10:15
 */
public interface ScriptEngine {

    /**
     * 执行一个指定名称的脚本
     * @param scriptName
     * @param parameters
     * @return
     */
    Object run(String scriptName,Object parameters);

    /**
     * 执行一个指定的方法，附带参数
     * @param scriptName
     * @param functionName
     * @param parameters
     * @return
     */
    Object run(String scriptName,String functionName,Object parameters);



}
