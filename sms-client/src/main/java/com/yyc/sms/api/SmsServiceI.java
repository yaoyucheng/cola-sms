package com.yyc.sms.api;

import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.dto.qry.SmsQry;

import java.util.List;
import java.util.Map;

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
     * 获取短信
     *
     * @param smsQry
     * @return
     */
    List<SmsDTO> getSms(SmsQry smsQry);

    /**
     * 消费smsUp 业务数据
     *
     * @param contentMap 返回数据
     * @return
     */
    boolean dealSmsUpBusiness(Map<String, Object> contentMap);
}
