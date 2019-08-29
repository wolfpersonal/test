package com.frxs.ocean.domain.dto.partner.apiconfig;

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
 * @version PartnerApiConfig.java, v 1.0 2019年08月10日 16:27
 */
@Getter
@Setter
@ToString
@TableName("t_partner_api_config")
public class PartnerApiConfig extends Model<PartnerApiConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自动增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 合作方id
     */
    private Integer partnerId;

    /**
     * 协议类型http:1,https:2,ftp:4,tcp:8,smtp:16,udp:32
     */
    private String protocalType;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 是否限速
     */
    private Integer islimited;

    /**
     * 限速大小
     */
    private Integer limitCount;

    /**
     * 限速周期，1：秒，2：分，3：时，4：天
     */
    private Integer limitPeriod;

    /**
     * 创建时间
     */
    private Date tmCreate;

    /**
     * 最后修改时间
     */
    private Date tmSmp;

    /**
     * 接口状态：UNUSED：未启用，NORMAL：启用，LOCKED：锁定
     */
    private StatusEnum status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
