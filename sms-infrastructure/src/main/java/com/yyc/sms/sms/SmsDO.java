package com.yyc.sms.sms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yyc.sms.BaseDO;
import lombok.Data;

/**
 * 短信数据库映射
 *
 * @author 10916
 */
@Data
public class SmsDO extends BaseDO {

    /**
     * 入参----------------------------------------
     */

    /**
     * 接收短信的手机号码，JSON数组格式。
     * 实例：["15900000000","13500000000"]
     */
    @TableField(value = "sms_phone_number_json")
    private String phoneNumberJson;

    /**
     * 短信模板变量对应的实际值，JSON格式。
     * 对应 templateCode 中的值
     */
    @TableField(value = "sms_template_param")
    private String templateParam;

    /**
     * 流水字段
     */
    @TableField(value = "sms_out_id")
    private String outId;

    /**
     * 上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     */
    @TableField(value = "sms_up_extend_code")
    private String smsUpExtendCode;

    /**
     * sms-config----------------------------------------
     */

    /**
     * 短信签名名称
     * 实例：阿里云
     */
    @TableField(value = "sms_sign_name")
    private String signName;

    /**
     * 短信模板CODE。请在控制台模板管理页面模板CODE一列查看。
     * 实例：SMS_152550005
     */
    @TableField(value = "sms_template_code")
    private String templateCode;


    /**
     * 产品域名 domain  dysmsapi.aliyuncs.com
     */
    @TableField(value = "sms_domain")
    public String domain;

    /**
     * accessKey
     */
    @TableField(value = "sms_access_key")
    private String accessKey;

    /**
     * sms-identifies-----------------------------------------
     */

    /**
     * 唯一标识
     */
    @TableField(value = "sms_identifies")
    private String identifies;
}
