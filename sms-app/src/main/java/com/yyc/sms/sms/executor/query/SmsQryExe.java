package com.yyc.sms.sms.executor.query;

import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.qry.SmsQry;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuchengyao
 */
@Component
public class SmsQryExe {

    @Resource
    private SmsGateway smsGateway;

    public List<SmsDTO> getSmsExe(SmsQry smsQry) {
        return smsGateway.list(smsQry);
    }

}
