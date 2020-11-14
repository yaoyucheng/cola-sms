package com.yyc.sms.sms.executor.query;

import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.sms.SmsDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuchengyao
 */
@Component
public class SmsByOutIdsExe {

    @Resource
    private SmsGateway smsGateway;

    public List<SmsDTO> getSmsByOutIdsExe(String... outIds) {
        return smsGateway.getSmsByOutIdsExe(outIds);
    }

}
