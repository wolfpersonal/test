/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.domain.dto.script;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.frxs.ocean.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lifeng.weng
 * @version Script.java, v 1.0 2019年08月10日 16:27
 */
@Getter
@Setter
@ToString
@TableName("t_script")
public class Script extends Model<Script> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自动增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 脚本引擎类型，1：js，2：groovy
     */
    private Integer scriptType;

    /**
     * 脚本保存地址
     */
    private String scriptUrl;

    /**
     * 创建时间
     */
    private Date tmCreate;

    /**
     * 修改时间
     */
    private Date tmSmp;

    /**
     * 脚本状态，UNUSED：未启用，NORMAL：启用，LOCKED：锁定
     */
    private StatusEnum status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
