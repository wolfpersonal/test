/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.dao.app;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.frxs.ocean.domain.dto.app.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

/**
 * @author lifeng.weng
 * @version .java, v 1.0 2019年08月12日 16:19
 */

@SpringBootTest(classes = {MyApplication.class})
@SpringBootConfiguration
@RunWith(SpringRunner.class)
public class AppMapperTest {

    @Autowired
    private AppMapper appMapper;

    @Test
    public void findByIdTest() {

        App app = appMapper.selectById(1);
        Assert.assertNotNull(app);
        Assert.assertEquals(app.getOwner(),"wolf");
    }
}