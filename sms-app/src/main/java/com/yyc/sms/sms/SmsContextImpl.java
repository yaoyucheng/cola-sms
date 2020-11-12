package com.yyc.sms.sms;

import com.yyc.sms.api.SmsContextI;
import com.yyc.sms.dto.data.SmsContext;
import org.springframework.stereotype.Component;

/**
 * @author yuchengyao
 */
@Component
public class SmsContextImpl implements SmsContextI {

    /**
     * 线程环境
     */
    private static final ThreadLocal<SmsContext> smsContent = new ThreadLocal<>();

    /**
     * 无效对象
     */
    private static final SmsContext emptySmsContext = SmsContext.builder().build();

    @Override
    public SmsContext getSmsContent() {
        return smsContent.get() == null ? SmsContext.builder().build() : emptySmsContext;
    }

    @Override
    public void setSmsContent(SmsContext smsContext) {
        smsContent.set(smsContext);
    }

    @Override
    public void clean() {
        smsContent.set(emptySmsContext);
    }
}
