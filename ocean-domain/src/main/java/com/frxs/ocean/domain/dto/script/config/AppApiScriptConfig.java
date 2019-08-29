/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.domain.dto.script.config;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lifeng.weng
 * @version ScriptConfig.java, v 1.0 2019年08月10日 16:27
 */
@Getter
@Setter
@ToString
@TableName("t_app_api_script_config")
public class AppApiScriptConfig extends Model<AppApiScriptConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自动增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 应用Id
     */
    private Integer appId;

    /**
     * 对应apiId
     */
    private Integer apiId;

    /**
     * 排序，可能有多个，升序规则，由小到大
     */
    private Integer order;

    /**
     * 脚本Id
     */
    private Integer scriptId;

    /**
     * 脚本类型：1：验签、2：数据拼装、3：返回数据解析
     */
    private Integer type;

    /**
     * 0：未启用，1：启用，2：锁定
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastModify;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
