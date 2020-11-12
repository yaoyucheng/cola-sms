package com.yyc.sms.sms;

import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 10916
 */
@Component
public class SmsGatewayImpl implements SmsGateway {

    @Resource
    private SmsMapper smsMapper;

    @Override
    public void insert(Sms sms) {

        SmsDO smsDO = new SmsDO();

        BeanUtils.copyProperties(sms, smsDO);

        smsMapper.insert(smsDO);

    }
}
