package com.yyc.sms.expetion;

import com.alibaba.cola.exception.ErrorCodeI;

/**
 * sms 业务异常code定义
 *
 * @author yuchengyao
 */
public enum ErrorCode implements ErrorCodeI {

    SMS_ALIBABA_EXCEPTION("SMS_ALIBABA_EXCEPTION", "短信发送异常"),

    SMS_CONFIG_PARAMETER_EXCEPTION("SMS_CONFIG_PARAMETER_EXCEPTION", "短信配置参数异常"),

    SMS_REQUEST_PARAMETER_EXCEPTION("SMS_REQUEST_PARAMETER_EXCEPTION", "短信请求参数异常"),

    SMS_RECEIVER_HANDLE_NULL("SMS_RECEIVER_HANDLE_NULL", "短信接收者处理器空"),

    SMS_UP_DATA_NULL("SMS_UP_DATA_NULL", "短信上行处理时基础数据为NULL"),

    SMS_UP_DATA_EXCEPTION("SMS_UP_DATA_NULL", "短信上行处理时基础数据异常"),
    ;

    private final String errCode;
    private final String errDesc;

    private ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrDesc() {
        return errDesc;
    }
}
