package com.yyc.sms.sms;

import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.sms.executor.SmsSendCmdExe;
import com.yyc.sms.sms.executor.query.SmsByOutIdsExe;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 发送消息
     *
     * @param smsSendCmd
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SmsResponseDTO send(@NonNull SmsSendCmd smsSendCmd) {
        return smsSendCmdExe.send(smsSendCmd);
    }

    @Override
    public List<SmsDTO> getSmsByOutIds(@NonNull String... smsUpExtendCodes) {
        return smsByOutIdsExe.getSmsByOutIdsExe(smsUpExtendCodes);
    }
}
