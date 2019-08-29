///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.sofa;
//
//import com.alipay.sofa.rpc.config.ProviderConfig;
//import com.alipay.sofa.rpc.config.ServerConfig;
//
///**
// * @author wolf
// * @version QuickStartServer.java, v 1.0 2019年07月30日 15:23
// */
//public class QuickStartServer {
//
//    public static void main(String[] args) {
//        ServerConfig serverConfig = new ServerConfig()
//                .setProtocol("bolt") // 设置一个协议，默认bolt
//                .setProtocol("http")
//                .setPort(12200) // 设置一个端口，默认12200
//                .setDaemon(false); // 非守护线程
//
//        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
//                .setInterfaceId(HelloService.class.getName()) // 指定接口
//                .setRef(new HelloServiceImpl()) // 指定实现
//                .setServer(serverConfig); // 指定服务端
//
//        providerConfig.export(); // 发布服务
//    }
//}