package com.yyc.sms.domain.sms.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 10916
 */
@Data
@Builder
public class Sms {

    /**
     * 接收短信的手机号码，JSON数组格式。
     * 实例：["15900000000","13500000000"]
     */
    private String phoneNumberJson;

    /**
     * 短信签名名称
     * 实例：阿里云
     */
    private String signName;

    /**
     * 短信模板CODE。请在控制台模板管理页面模板CODE一列查看。
     * 实例：SMS_152550005
     */
    private String templateCode;

    /**
     * 短信模板变量对应的实际值，JSON格式。
     * 对应 templateCode 中的值
     */
    private String templateParam;

    /**
     * 流水字段
     */
    private String outId;

    /**
     * 上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     */
    private String smsUpExtendCode;

}
