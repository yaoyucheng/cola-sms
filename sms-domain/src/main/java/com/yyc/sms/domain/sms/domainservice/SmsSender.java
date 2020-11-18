package com.yyc.sms.domain.sms.domainservice;

import com.alibaba.cola.exception.BizException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.entity.SmsResponse;
import com.yyc.sms.domain.util.JsonUtils;
import com.yyc.sms.dto.data.SmsContext;
import com.yyc.sms.expetion.ErrorCode;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 短信发送者
 *
 * @author 10916
 */
@Slf4j
public class SmsSender {

    public static SmsResponse send(Sms sms) {
        return (SmsResponse) send(
                sms.getPhoneNumberJson(),
                sms.getTemplateParam(),
                sms.getSignName(),
                sms.getTemplateCode());
    }

    /**
     * @param phoneNumbers
     * @param templateParam
     * @return
     */
    public static SendSmsResponse send(@NonNull String phoneNumbers,
                                       @NonNull String templateParam,
                                       @NonNull String signName,
                                       @NonNull String templateCode) {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        SmsContext smsContent = SmsThreadLocalContextContainer.getSmsContent();

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", smsContent.getAccessKey(), smsContent.getAccessKeySecret());

        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();

        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumbers);

        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(templateParam);

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;

        log.info("请求参数：->{}", JsonUtils.toString(request));
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            log.error(e.getMessage(), e);
            throw new BizException(ErrorCode.SMS_ALIBABA_EXCEPTION, e.getMessage());
        }
        return sendSmsResponse;
    }
}
