package com.yyc.sms.sms;

import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.sms.executor.SmsSendCmdExe;
import com.yyc.sms.sms.executor.query.SmsByOutIdsExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10916
 */
@Service
public class SmsServiceImpl implements SmsServiceI {

    @Resource
    private SmsSendCmdExe smsSendCmdExe;

    @Resource
    private SmsByOutIdsExe smsByOutIdsExe;

    @Override
    public SmsResponseDTO send(SmsSendCmd smsSendCmd) {
        return smsSendCmdExe.send(smsSendCmd);
    }

    @Override
    public List<SmsDTO> getSmsByOutIds(String... outIds) {
        return smsByOutIdsExe.getSmsByOutIdsExe(outIds);
    }
}
