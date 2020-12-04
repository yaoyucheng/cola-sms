package com.yyc.sms.sms.executor;

import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yuchengyao
 */
@Component
public class SmsConsumptionExe {

    @Resource
    private SmsGateway smsGateway;

    /**
     * 消费短信
     */
    public void consumptionSms(@NonNull String identifies, @NonNull String content) {
        smsGateway.update(identifies, Sms.builder().replyContent(content).build());
    }
}
