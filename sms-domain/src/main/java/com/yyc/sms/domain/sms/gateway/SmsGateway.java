package com.yyc.sms.domain.sms.gateway;

import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.dto.data.SmsDTO;

import java.util.List;

/**
 * @author 10916
 */
public interface SmsGateway {

    /**
     * 保存短信
     *
     * @param sms
     */
    void insert(Sms sms);

    /**
     * 获取短信具体信息
     *
     * @param outIds 外部唯一标识
     * @return
     */
    List<SmsDTO> getSmsByOutIdsExe(String... outIds);
}
