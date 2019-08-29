///*
// * frxs Inc.  湖南兴盛优选电子商务有限公司.
// * Copyright (c) 2017-2019. All Rights Reserved.
// */
//package com.frxs.ocean.service.sofa;
//
//import com.alipay.sofa.rpc.config.*;
//import com.alipay.sofa.rpc.registryProvider.RegistryFactory;
//import com.alipay.sofa.rpc.registryProvider.sofa.SofaRegistry;
//import com.alipay.sofa.rpc.registryProvider.sofa.SofaRegistryHelper;
//import com.alipay.sofa.rpc.registryProvider.zk.ZookeeperRegistry;
//import org.junit.*;
//import org.junit.runner.RunWith;
//
///**
// * @author wolf
// * @version SofaRegistryTest.java, v 1.0 2019年07月31日 19:15
// */
//
//public class SofaRegistryTest {
//
//    private static RegistryConfig registryConfig;
//
//    private static ZookeeperRegistry registryProvider;
//
//    private static ConsumerConfig<HelloService> consumer1;
//    private static ConsumerConfig<?> consumer2;
//
//    private static ServerConfig serverConfig1;
//    private static ServerConfig serverConfig2;
//
//    private static ProviderConfig<HelloService> provider;
//
//
//    @Before
//    public void setUp() {
//
//        registryConfig = new RegistryConfig()
//                .setProtocol("zookeeper")
//                .setSubscribe(true)
//                .setRegister(true)
//                .setAddress("127.0.0.1:2181");
//
//        registryProvider = (ZookeeperRegistry) RegistryFactory.getRegistry(registryConfig);
//        registryProvider.init();
//        Assert.assertTrue(registryProvider.start());
//    }
//
//    @After
//    public void tearDown() {
//        registryProvider.destroy();
//        registryProvider = null;
//
//        if (consumer1 != null) {
//            consumer1.unRefer();
//        }
//        if (consumer2 != null) {
//            consumer2.unRefer();
//        }
//        if (serverConfig1 != null) {
//            serverConfig1.destroy();
//        }
//        if (serverConfig2 != null) {
//            serverConfig2.destroy();
//        }
//        if (provider != null) {
//            provider.unExport();
//        }
//    }
//
//
//    @Test
//    public void testAll() throws Exception {
//
//        int timeoutPerSub = 5000;
//
//        serverConfig1 = new ServerConfig()
//                .setProtocol("bolt")
//                .setHost("0.0.0.0")
//                .setPort(12200);
//
//        provider = new ProviderConfig();
//
//        provider.setInterfaceId("com.frxs.ocean.service.sofa.HelloService")
//                .setUniqueId("unique123Id")
//                .setGroup("aaa")
//                .setApplication(new ApplicationConfig().setAppName("test-server"))
//                .setProxy("javassist")
//                .setRegister(true)
//                .setRegistry(registryConfig)
//                .setSerialization("protobuffer")
//                .setServer(serverConfig1)
//                .setWeight(222)
//                .setRef(new HelloServiceImpl())
//                .setTimeout(3000);
//
//        // 注册
//        provider.export();
//        registryProvider.register(provider);
//
//        consumer1 = new ConsumerConfig<HelloService>();
//        consumer1.setInterfaceId("com.frxs.ocean.service.sofa.HelloService")
//                .setUniqueId("unique123Id")
//                .setApplication(new ApplicationConfig().setAppName("test-server"))
//                .setProxy("javassist")
//                .setSubscribe(true)
//                .setSerialization("protobuffer")
//                .setInvokeType("sync")
//                .setRegistry(registryConfig)
//                .setTimeout(4444);
//        String tag0 = SofaRegistryHelper.buildListDataId(provider, serverConfig1.getProtocol());
//        String tag1 = SofaRegistryHelper.buildListDataId(consumer1, consumer1.getProtocol());
//        System.out.println(consumer1.refer().sayHello("world"));
//        Assert.assertEquals(tag1, tag0);
//
//    }
//
//
//}
