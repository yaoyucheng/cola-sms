package com.yyc.sms.api;

import com.yyc.sms.dto.data.SmsContext;

/**
 * @author yuchengyao
 */
public interface SmsContextI {

    /**
     * 产品名称:云通信短信API产品
     */
    public static String PRODUCT = "Dysmsapi";

    /**
     * 获取当前的短信上下文
     *
     * @return
     */
    SmsContext getSmsContent();

    /**
     * 设置当前的短信上下文
     *
     * @param smsContext
     */
    void setSmsContent(SmsContext smsContext);

    /**
     * 当前环境短信上下文清除
     */
    void clean();


}
