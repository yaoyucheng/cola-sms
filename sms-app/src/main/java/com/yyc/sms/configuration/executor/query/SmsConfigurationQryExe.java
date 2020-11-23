package com.yyc.sms.configuration.executor.query;

import com.yyc.sms.domain.sms.gateway.SmsConfigurationGateway;
import com.yyc.sms.dto.qry.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuchengyao
 */
@Component
public class SmsConfigurationQryExe {

    @Resource
    private SmsConfigurationGateway smsConfigurationGateway;

    public List<SmsConfigurationDTO> getSmsConfiguration(SmsConfigurationQry smsConfigurationQry) {

        return smsConfigurationGateway.getSmsConfiguration(smsConfigurationQry);
    }
}
