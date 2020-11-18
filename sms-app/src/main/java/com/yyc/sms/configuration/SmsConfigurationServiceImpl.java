package com.yyc.sms.configuration;

import com.yyc.sms.api.SmsConfigurationServiceI;
import com.yyc.sms.configuration.executor.CheckInitializationExe;
import com.yyc.sms.configuration.executor.query.SmsConfigurationQryExe;
import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuchengyao
 */
@Service
public class SmsConfigurationServiceImpl implements SmsConfigurationServiceI {

    @Resource
    private CheckInitializationExe checkInitializationExe;

    @Resource
    private SmsConfigurationQryExe smsConfigurationQryExe;

    @Override
    public boolean checkInitialization() {
        return checkInitializationExe.checkInitialization();
    }

    @Override
    public List<SmsConfigurationDTO> getConfiguration(SmsConfigurationQry smsConfigurationQry) {
        return smsConfigurationQryExe.getSmsConfiguration(smsConfigurationQry);
    }

    @Override
    public SmsConfigurationDTO getConfiguration(String accessKey) {
        return smsConfigurationQryExe.getSmsConfiguration(SmsConfigurationQry.builder().accessKey(accessKey).build()).get(0);
    }
}
