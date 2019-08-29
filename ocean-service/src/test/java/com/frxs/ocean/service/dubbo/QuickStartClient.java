///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.sofa;
//
//import com.alipay.sofa.rpc.config.ConsumerConfig;
//import com.alipay.sofa.rpc.core.exception.SofaRpcException;
//import com.alipay.sofa.rpc.core.invoke.SofaResponseCallback;
//import com.alipay.sofa.rpc.core.request.RequestBase;
//
///**
// * @author wolf
// * @version QuickStartClient.java, v 1.0 2019年07月30日 15:20
// */
//public class QuickStartClient {
//
//    public static void main(String[] args) {
//        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
//                .setInterfaceId(HelloService.class.getName()) // 指定接口
//                .setProtocol("bolt") // 指定协议
//                .setDirectUrl("bolt://127.0.0.1:12200").setInvokeType("callback").setOnReturn(new SofaResponseCallback() {
//                    public void onAppResponse(Object o, String s, RequestBase requestBase) {
//                        System.out.println("o:"+o);
//                        System.out.println("s:"+s);
//                        System.out.println("requestBase:"+requestBase.toString());
//                    }
//
//                    public void onAppException(Throwable throwable, String s, RequestBase requestBase) {
//                        System.out.println("s:"+s);
//                    }
//
//                    public void onSofaException(SofaRpcException e, String s, RequestBase requestBase) {
//                        System.out.println("s:"+s);
//                    }
//                }); // 指定直连地址
//        // 生成代理类
//        HelloService helloService = consumerConfig.refer();
//        while (true) {
//            System.out.println(helloService.sayHello("world"));
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e) {
//            }
//        }
//    }
//}