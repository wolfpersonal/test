///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.sofa;
//
//import com.eclipsesource.v8.JavaCallback;
//import com.eclipsesource.v8.NodeJS;
//import com.eclipsesource.v8.V8Array;
//import com.eclipsesource.v8.V8Object;
//import groovy.lang.GroovyObject;
//import groovy.util.GroovyScriptEngine;
//import groovy.util.ResourceException;
//import groovy.util.ScriptException;
//import org.apache.commons.io.FileUtils;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.concurrent.CountDownLatch;
//
///**
// * @author wolf
// * @version ScriptBenchMarkTest.java, v 1.0 2019年08月06日 15:07
// */
//
//public class ScriptBenchMarkTest {
//
//
//    private static GroovyScriptEngine gse = null;
//    private static GroovyObject groovyObject = null;
//    static NodeJS nodeJS = null;
//
//    private static void initEngine() throws IOException, ResourceException, ScriptException, IllegalAccessException, InstantiationException {
//        String[] roots = new String[]{J2V8Test.class.getClassLoader().getResource("groovy/script").getPath()};
//        gse = new GroovyScriptEngine(roots);
//        groovyObject = (GroovyObject) gse.loadScriptByName("httpget.groovy").newInstance();
//    }
//
//
//    @Test
//    public void testHttpRequest() throws InterruptedException, ResourceException, ScriptException, InstantiationException, IllegalAccessException, IOException {
//        initEngine();
//        int times = 10;
//        String host = "www.baidu.com";
//        jsHttpRequest(times, host);
//        testHttpGroovyRequest(times,host);
//
//        times = 100;
//
//        jsHttpRequest(times, host);
//        testHttpGroovyRequest(times,host);
//
//
//        times = 1000;
//
//        jsHttpRequest(times, host);
//        testHttpGroovyRequest(times,host);
//    }
//
//    public void testHttpGroovyRequest(int times, String host) {
//        long startTime =System.currentTimeMillis();
//        String fullUrl = "http://" +host;
//        for( int i = 0 ; i< times ; i++){
//            groovyObject.invokeMethod("testHttpRequest",fullUrl);
//        }
//
//        System.out.println(String.format("groovy request http url : %s ,times : %d ,cost times : %d", fullUrl, times, (System.currentTimeMillis() - startTime)));
//    }
//
//    private void jsHttpRequest(int times, String url) throws InterruptedException, IOException {
//        nodeJS = NodeJS.createNodeJS();
//        long startTime = System.currentTimeMillis();
//        final CountDownLatch cd = new CountDownLatch(times);
//        JavaCallback callback = new JavaCallback() {
//            public Object invoke(V8Object v8Object, V8Array v8Array) {
//                cd.countDown();
//                return null;
//            }
//        };
//
//
//        String path = J2V8Test.class.getClassLoader().getResource("js/script/httpget.js").getPath();
//        V8Object v8Function = nodeJS.require(createTemporaryScriptFile(FileUtils.readFileToString(new File(path), "utf-8"), "test"));
//
//        V8Array v8Parameter = new V8Array(nodeJS.getRuntime());
//        v8Parameter.push(url);
//
//        nodeJS.getRuntime().registerJavaMethod(callback, "countDown");
//        for (int i = 0; i < times; i++) {
//            v8Function.executeVoidFunction("testHttp", v8Parameter);
//        }
//
//
//        while (nodeJS.isRunning()) {
//            nodeJS.handleMessage();
//        }
//        cd.await();
//
//        System.out.println(String.format("js request http url : %s ,times : %d ,cost times : %d", url, times, (System.currentTimeMillis() - startTime)));
//    }
//
//    private static File createTemporaryScriptFile(final String script, final String name) throws IOException {
//        File tempFile = File.createTempFile(name, ".js.tmp");
//        PrintWriter writer = new PrintWriter(tempFile, "UTF-8");
//        try {
//            writer.print(script);
//        } finally {
//            writer.close();
//        }
//        return tempFile;
//    }
//
//
//}