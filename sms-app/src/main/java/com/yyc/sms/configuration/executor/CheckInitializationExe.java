package com.yyc.sms.configuration.executor;

import com.yyc.sms.api.SmsConfigurationServiceI;
import com.yyc.sms.domain.sms.gateway.SmsConfigurationGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yuchengyao
 */
@Component
public class CheckInitializationExe {

    @Resource
    private SmsConfigurationGateway smsConfigurationGateway;

    /**
     * 校验配置是否需要重载
     *
     * @return
     */
    public boolean checkInitialization() {
        return smsConfigurationGateway.checkInitialization();
    }
}
