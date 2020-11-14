package com.yyc.sms.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;

import java.util.List;

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

    /**
     * 通过 outId 列表获取短信信息
     *
     * @param outIds
     * @return
     */
    List<SmsDTO> getSmsByOutIds(String... outIds);
}
