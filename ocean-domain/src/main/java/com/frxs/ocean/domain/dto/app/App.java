/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.domain.dto.app;

import com.baomidou.mybatisplus.annotations.TableName;
import com.frxs.ocean.domain.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author lifeng.weng
 * @version App.java, v 1.0 2019年08月10日 16:27
 */

@Data
@TableName("t_app")
public class App {

    /** 主键，自动增长*/
    private int id;

    /** 应用名称*/
    private String name;

    /** 应用编码*/
    private String code;

    /** 应用负责人*/
    private String owner;

    /** 应用责任人id*/
    private int ownerId;

    /** 应用状态*/

    private StatusEnum status;

    /** 创建日期*/
    private Date tmCreate;

    /** 最后修改时间*/
    private Date tmSmp;

}