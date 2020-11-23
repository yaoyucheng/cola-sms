package com.yyc.sms.domain.sms.gateway;

import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.qry.SmsQry;

import java.util.List;

/**
 * @author 10916
 */
public interface SmsGateway {

    /**
     * 保存短信信息
     *
     * @param sms
     */
    void insert(Sms sms);

    /**
     * 更新短信信息
     *
     * @param smsUpExtendCode 唯一标识
     * @param sms
     */
    void update(String smsUpExtendCode, Sms sms);

    /**
     * 获取短信列表
     *
     * @param smsQry
     * @return
     */
    List<SmsDTO> list(SmsQry smsQry);

}
