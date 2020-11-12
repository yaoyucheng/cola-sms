package com.yyc.sms.sms.executor;

import com.yyc.sms.domain.sms.domainservice.SmsSender;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.entity.SmsResponse;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsResponseDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 10916
 */
@Component
public class SmsSendCmdExe {

    @Resource
    private SmsGateway smsGateway;

    @Resource
    private SmsSender smsSender;

    public SmsResponseDTO send(SmsSendCmd smsSendCmd) {

        //  发送短信
        SmsResponse smsResponse = smsSender.send(buildSendSms(smsSendCmd));

        //  保存短信信息
        smsGateway.insert(buildInsertSms(smsSendCmd, smsResponse));

        //  构造标准返回信息返回
        return buildSmsResponseDTO(smsResponse);
    }

    /**
     * 构造标准返回值
     *
     * @param smsResponse
     * @return
     */
    private SmsResponseDTO buildSmsResponseDTO(SmsResponse smsResponse) {
        //  构造标准返回值
        return SmsResponseDTO.builder()
                .bizId(smsResponse.getBizId())
                .code(smsResponse.getCode())
                .message(smsResponse.getCode())
                .requestId(smsResponse.getRequestId())
                .build();
    }

    /**
     * 构建发送的短信数据
     *
     * @param smsSendCmd
     * @return
     */
    private Sms buildSendSms(SmsSendCmd smsSendCmd) {

        //  TODO :构建发送的短信数据
        return Sms.builder().
                build();
    }

    /**
     * 构建新增的短信数据
     *
     * @param smsSendCmd
     * @param smsResponse
     * @return
     */
    private Sms buildInsertSms(SmsSendCmd smsSendCmd, SmsResponse smsResponse) {

        //  TODO:构建新增的短信数据
        return Sms.builder().
                build();
    }

}
