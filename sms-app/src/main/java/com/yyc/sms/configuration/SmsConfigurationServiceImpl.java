package com.yyc.sms.configuration;

import com.alibaba.cola.exception.BizException;
import com.yyc.sms.api.SmsConfigurationServiceI;
import com.yyc.sms.configuration.executor.CheckInitializationExe;
import com.yyc.sms.configuration.executor.query.SmsConfigurationQryExe;
import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;
import com.yyc.sms.expetion.ErrorCode;
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
        List<SmsConfigurationDTO> smsConfiguration = smsConfigurationQryExe.getSmsConfiguration(SmsConfigurationQry.builder().accessKey(accessKey).build());
        if (smsConfiguration == null || smsConfiguration.isEmpty()) {
            throw new BizException(ErrorCode.SMS_REQUEST_PARAMETER_EXCEPTION, "短信请求参数异常");
        }
        return smsConfiguration.get(0);
    }
}
