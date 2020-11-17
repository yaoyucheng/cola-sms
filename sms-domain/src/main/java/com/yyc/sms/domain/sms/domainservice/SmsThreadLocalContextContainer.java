package com.yyc.sms.domain.sms.domainservice;

import com.yyc.sms.dto.data.SmsContext;

/**
 * 线程中的短信配置
 *
 * @author yuchengyao
 */
public class SmsThreadLocalContextContainer {

    /**
     * 线程环境
     */
    private static final ThreadLocal<SmsContext> smsContent = new ThreadLocal<>();

    /**
     * 无效对象
     */
    private static final SmsContext emptySmsContext = SmsContext.builder().build();

    public static SmsContext getSmsContent() {
        return smsContent.get() == null ? SmsContext.builder().build() : emptySmsContext;
    }

    public static void setSmsContent(SmsContext smsContext) {
        smsContent.set(smsContext);
    }

    public static void clean() {
        smsContent.set(emptySmsContext);
    }
}
