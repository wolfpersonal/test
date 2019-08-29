/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.ocean.domain.dto.partner;

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
 * @version Partner.java, v 1.0 2019年08月10日 16:27
 */
@Getter
@Setter
@ToString
@TableName("t_partner")
public class Partner extends Model<Partner> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自动增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 合作方名称
     */
    private String name;

    /**
     * 合作方code
     */
    private String code;

    /**
     * 创建时间
     */
    private Date tmCreate;

    /**
     * 最后修改时间
     */
    private Date tmSmp;

    /**
     * 合作方状态，UNUSED：未启用，NORMAL：启用，LOCKED：锁定
     */
    private StatusEnum status;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
