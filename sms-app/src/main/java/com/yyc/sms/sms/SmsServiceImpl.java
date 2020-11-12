package com.yyc.sms.sms;

import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.sms.executor.SmsSendCmdExe;

import javax.annotation.Resource;

/**
 * @author 10916
 */
public class SmsServiceImpl implements SmsServiceI {

    @Resource
    private SmsSendCmdExe smsSendCmdExe;

    @Override
    public SmsResponseDTO send(SmsSendCmd smsSendCmd) {
        return smsSendCmdExe.send(smsSendCmd);
    }
}
