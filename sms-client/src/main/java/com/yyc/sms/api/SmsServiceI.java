package com.yyc.sms.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsResponseDTO;

/**
 * @author 10916
 */
public interface SmsServiceI {

    /**
     * 发送短信
     *
     * @param smsSendCmd
     * @return
     */
    SmsResponseDTO send(SmsSendCmd smsSendCmd);

}
