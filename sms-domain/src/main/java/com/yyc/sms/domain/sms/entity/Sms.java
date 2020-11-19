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
     * sms-identifies-----------------------------------------
     */

    /**
     * 唯一标识
     */
    private String identifies;

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
     * 签名
     */
    private String signName;

    /**
     * 模板code
     */
    private String templateCode;

    /**
     * 返回参数-----------------------------------------------
     */

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 发送回执ID，可根据该ID在接口QuerySendDetails中查询具体的发送状态。
     */
    private String bizId;

    /**
     * 请求状态码。
     */
    private String code;

    /**
     * 状态码的描述。
     */
    private String message;

    /**
     * 配置参数-------------------------------------------------
     */

    /**
     * accessKey
     */
    private String accessKey;
}
