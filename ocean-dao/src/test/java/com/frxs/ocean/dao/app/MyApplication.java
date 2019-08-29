/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.dao.app;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lifeng.weng
 * @version MyApplication.java, v 1.0 2019年08月14日 15:32
 */
@EnableApolloConfig(value = "application", order = 1)
@SpringBootApplication(scanBasePackages = {"com.frxs.ocean"})
@MapperScan(basePackages = {"com.frxs.ocean"})
public class MyApplication {
}