package com.yyc.sms.domain.sms.gateway;

import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;

import java.util.List;

/**
 * @author yuchengyao
 */
public interface SmsConfigurationGateway {


    /**
     * 获取配置
     *
     * @param smsConfigurationQry
     * @return
     */
    List<SmsConfigurationDTO> getSmsConfiguration(SmsConfigurationQry smsConfigurationQry);

    /**
     * 获取配置
     *
     * @return
     */
    List<SmsConfigurationDTO> getSmsConfiguration();

    /**
     * 校验配置是否更新
     *
     * @return
     */
    boolean checkInitialization();
}
