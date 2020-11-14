package com.yyc.sms.sms.context;

import com.yyc.sms.dto.data.SmsContext;

/**
 * @author yuchengyao
 */
public class SmsContextContainer {

    /**
     * 线程环境
     */
    private static final ThreadLocal<com.yyc.sms.dto.data.SmsContext> smsContent = new ThreadLocal<>();

    /**
     * 无效对象
     */
    private static final com.yyc.sms.dto.data.SmsContext emptySmsContext = com.yyc.sms.dto.data.SmsContext.builder().build();

    public static SmsContext getSmsContent() {
        return smsContent.get() == null ? com.yyc.sms.dto.data.SmsContext.builder().build() : emptySmsContext;
    }

    public static void setSmsContent(com.yyc.sms.dto.data.SmsContext smsContext) {
        smsContent.set(smsContext);
    }

    public static void clean() {
        smsContent.set(emptySmsContext);
    }
}
