package com.yyc.sms.api;

import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;

import java.util.List;

/**
 * @author yuchengyao
 */
public interface SmsConfigurationServiceI {

    /**
     * 校验sms configuration 是否初始化
     *
     * @return
     */
    boolean checkInitialization();

    /**
     * 获取配置
     *
     * @param smsConfigurationQry 查询参数
     * @return
     */
    List<SmsConfigurationDTO> getConfiguration(SmsConfigurationQry smsConfigurationQry);

    /**
     * 获取查询 accessKey 的配置
     *
     * @param accessKey
     * @return
     */
    SmsConfigurationDTO getConfiguration(String accessKey);
}
