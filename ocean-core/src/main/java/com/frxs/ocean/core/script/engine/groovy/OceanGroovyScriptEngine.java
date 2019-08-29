/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.core.script.engine.groovy;

import com.frxs.ocean.core.script.engine.ScriptEngine;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

/**
 * @author lifeng.weng
 * @version OceanGroovyScriptEngine.java, v 1.0 2019年08月10日 10:19
 */
public class OceanGroovyScriptEngine implements ScriptEngine {

    private static GroovyScriptEngine gse = null;
    private static GroovyObject groovyObject = null;

    
    String[] roots =  null;
    public void init() throws IOException, ResourceException, ScriptException {
        gse = new GroovyScriptEngine(roots);

    }


    @Override
    public Object run(String scriptName, Object parameters) {
        return null;
    }

    @Override
    public Object run(String scriptName, String functionName, Object parameters) {
        return null;
    }
}