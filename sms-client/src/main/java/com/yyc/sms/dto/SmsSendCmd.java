package com.yyc.sms.dto;

import lombok.Data;

/**
 * @author 10916
 */
@Data
public class SmsSendCmd {

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
     * 签名
     */
    private String signName;

    /**
     * 模板code
     */
    private String templateCode;

}
