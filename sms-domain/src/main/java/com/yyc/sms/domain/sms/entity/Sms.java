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
     * 入参----------------------------------------
     */

    /**
     * 接收短信的手机号码，JSON数组格式。
     * 实例：["15900000000","13500000000"]
     */
    private String phoneNumberJson;

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


    /**
     * sms-config----------------------------------------
     */
    /**
     * 产品域名 domain  dysmsapi.aliyuncs.com
     */
    public String domain;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

    /**
     * 签名
     */
    private String signName;

    /**
     * 模板code
     */
    private String templateCode;


    /**
     * sms-identifies-----------------------------------------
     */
    /**
     * 唯一标识
     */
    private String identifies;


}
