package com.yyc.sms.sms.executor;

import com.alibaba.cola.exception.BizException;
import com.yyc.sms.domain.sms.domainservice.SmsSender;
import com.yyc.sms.domain.sms.domainservice.SmsThreadLocalContextContainer;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.entity.SmsResponse;
import com.yyc.sms.domain.sms.gateway.SmsConfigurationGateway;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.domain.util.StringUtils;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.expetion.ErrorCode;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 10916
 */
@Component
public class SmsSendCmdExe {

    @Resource
    private SmsGateway smsGateway;

    public SmsResponseDTO send(@NonNull SmsSendCmd smsSendCmd) {

        //  check parameter 传参不可为空
        checkParameter(smsSendCmd);

        //  短信全局唯一标识
        String smsUuid = getIdentifies();

        //  发送短信
        SmsResponse smsResponse = SmsSender.send(buildSendSms(smsSendCmd));

        //  保存短信信息
        smsGateway.insert(buildInsertSms(smsSendCmd, smsResponse, smsUuid));

        //  构造标准返回信息返回
        return buildSmsResponseDTO(smsResponse, smsUuid);
    }

    /**
     * 获取短信全局唯一标识
     *
     * @return
     */
    private String getIdentifies() {
        return UUID.randomUUID().toString();
    }

    private void checkParameter(@NonNull SmsSendCmd smsSendCmd) {
        if (StringUtils.isAllNotEmpty(
                smsSendCmd.getOutId(),
                smsSendCmd.getPhoneNumberJson(),
                smsSendCmd.getSmsUpExtendCode(),
                smsSendCmd.getTemplateParam()
        )) {
            throw new BizException(ErrorCode.SMS_REQUEST_PARAMETER_EXCEPTION, "短信请求参数异常");
        }
    }

    /**
     * 构造标准返回值
     *
     * @param smsResponse
     * @return
     */
    private SmsResponseDTO buildSmsResponseDTO(@NonNull SmsResponse smsResponse, @NonNull String smsUuid) {
        //  构造标准返回值
        return SmsResponseDTO.builder()

                //  标准返回参数
                .bizId(smsResponse.getBizId())
                .code(smsResponse.getCode())
                .message(smsResponse.getCode())
                .requestId(smsResponse.getRequestId())

                //  短信全局唯一标识
                .identifies(smsUuid)
                .build();
    }

    /**
     * 构建发送的短信数据
     *
     * @param smsSendCmd
     * @return
     */
    private Sms buildSendSms(@NonNull SmsSendCmd smsSendCmd) {

        //  入参构建
        //  TODO :构建发送的短信数据
        return Sms.builder()
                .outId(smsSendCmd.getOutId())
                .phoneNumberJson(smsSendCmd.getPhoneNumberJson())
                .smsUpExtendCode(smsSendCmd.getSmsUpExtendCode())
                .templateParam(smsSendCmd.getTemplateParam())
                .signName(smsSendCmd.getSignName())
                .templateCode(smsSendCmd.getTemplateCode())
                .build();
    }

    /**
     * 构建新增的短信数据
     *
     * @param smsSendCmd
     * @return
     */
    private Sms buildInsertSms(@NonNull SmsSendCmd smsSendCmd, @NonNull SmsResponse smsResponse, @NonNull String smsUuid) {

        //  TODO:构建新增的短信数据
        return Sms.builder()
                //  唯一标识
                .identifies(smsUuid)

                //  smsSendCmd 请求参数
                .outId(smsSendCmd.getOutId())
                .phoneNumberJson(smsSendCmd.getPhoneNumberJson())
                .smsUpExtendCode(smsSendCmd.getSmsUpExtendCode())
                .templateParam(smsSendCmd.getTemplateParam())

                //  smsResponse 返回参数
                .requestId(smsResponse.getRequestId())
                .bizId(smsResponse.getBizId())
                .code(smsResponse.getCode())
                .message(smsResponse.getMessage())

                //  sms config 参数
                .accessKey(SmsThreadLocalContextContainer.getSmsContent().getAccessKey())
                .build();
    }

}
