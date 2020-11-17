package com.yyc.sms.configuration;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.yyc.sms.BaseDO;
import lombok.Data;

/**
 * @author yuchengyao
 */
@Data
@TableName(value = "sms_config")
@Table(name = "sms_config")
public class SmsConfigurationDO extends BaseDO {

    /**
     * 短信签名名称
     * 实例：阿里云
     */
    @Column(name = "sms_sign_name", type = MySqlTypeConstant.VARCHAR, comment = "短信签名名称")
    @TableField(value = "sms_sign_name")
    private String signName;

    /**
     * 短信模板CODE。请在控制台模板管理页面模板CODE一列查看。
     * 实例：SMS_152550005
     */
    @Column(name = "sms_template_code", type = MySqlTypeConstant.VARCHAR, comment = "短信模板CODE。请在控制台模板管理页面模板CODE一列查看。")
    @TableField(value = "sms_template_code")
    private String templateCode;


    /**
     * 产品域名 domain  dysmsapi.aliyuncs.com
     */
    @Column(name = "sms_domain", type = MySqlTypeConstant.VARCHAR, comment = "产品域名")
    @TableField(value = "sms_domain")
    public String domain;

    /**
     * accessKey
     */
    @Column(name = "sms_access_key", type = MySqlTypeConstant.VARCHAR, comment = "accessKey")
    @TableField(value = "sms_access_key")
    private String accessKey;

    /**
     * accessKeySecret
     */
    @Column(name = "access_key_secret", type = MySqlTypeConstant.VARCHAR, comment = "accessKeySecret")
    @TableField(value = "access_key_secret")
    private String accessKeySecret;

    /**
     * messageType
     */
    @Column(name = "message_type", type = MySqlTypeConstant.VARCHAR, comment = "messageType")
    @TableField(value = "message_type")
    private String messageType;

    /**
     * queueName
     */
    @Column(name = "queue_name", type = MySqlTypeConstant.VARCHAR, comment = "queueName")
    @TableField(value = "queue_name")
    private String queueName;


}
