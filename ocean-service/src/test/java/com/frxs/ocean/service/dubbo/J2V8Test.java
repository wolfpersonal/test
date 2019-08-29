///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.sofa;
//
//import com.eclipsesource.v8.V8;
//import groovy.lang.GroovyObject;
//import groovy.util.GroovyScriptEngine;
//import groovy.util.ResourceException;
//import groovy.util.ScriptException;
//
//import java.io.IOException;
//
///**
// * @author wolf
// * @version J2V8Test.java, v 1.0 2019年08月05日 11:02
// */
//public class J2V8Test {
//
//
//    public static void main(String[] args) throws ResourceException, ScriptException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
//
//        groovySimpleTest();
//
//        long startTime = System.currentTimeMillis();
//        V8 runtime = V8.createV8Runtime();
//        runtime.executeVoidScript("function strLength(){var hello ='hello',world = 'world!';return hello.concat(world).length();}");
//        int result = runtime.executeIntegerFunction("strLength",null);
//
//        System.out.println("result:"+result+" js cost time :"+(System.currentTimeMillis()-startTime));
//
//
//
//        long startTime2 = System.currentTimeMillis();
//        for( int i = 0 ; i < 10000;i++){
//
//            runtime.executeIntegerFunction("strLength",null);
//        }
//
//        System.out.println("run 10000 times , js cost time :"+(System.currentTimeMillis()-startTime2));
//        runtime.release();
//
//    }
//
//
//    static void groovySimpleTest() throws IOException, InstantiationException, IllegalAccessException, ResourceException, ScriptException {
//        long startTime = System.currentTimeMillis();
//        String[] roots = new String[] { J2V8Test.class.getClassLoader().getResource("groovy/script").getPath()};
//        //通过指定的roots来初始化GroovyScriptEngine
//        GroovyScriptEngine gse = new GroovyScriptEngine(roots);
//        GroovyObject groovyObject = (GroovyObject) gse.loadScriptByName("TestScript.groovy").newInstance();
//        Integer result = (Integer) groovyObject.invokeMethod("strLength",null);
//        System.out.println("result:"+result+"groovyscript cost time :"+(System.currentTimeMillis()-startTime));
//        long startTime2 = System.currentTimeMillis();
//        for( int i = 0 ; i < 10000;i++){
//            groovyObject.invokeMethod("strLength",null);
//        }
//
//        System.out.println("run 10000 times , groovyscript cost time :"+(System.currentTimeMillis()-startTime2));
//    }
//}