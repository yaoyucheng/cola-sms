package com.yyc.sms.domain.sms.gateway;

import com.yyc.sms.domain.sms.entity.Sms;

/**
 * @author 10916
 */
public interface SmsGateway {

    /**
     * 保存短信
     *
     * @param sms
     */
    void insert(Sms sms);
}
