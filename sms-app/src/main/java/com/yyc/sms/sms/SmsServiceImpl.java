package com.yyc.sms.sms;

import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;
import com.yyc.sms.dto.qry.SmsQry;
import com.yyc.sms.sms.executor.SmsConsumptionExe;
import com.yyc.sms.sms.executor.SmsSendCmdExe;
import com.yyc.sms.sms.executor.SmsUpBusinessDealExe;
import com.yyc.sms.sms.executor.query.SmsQryExe;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 10916
 */
@Service
public class SmsServiceImpl implements SmsServiceI {

    @Resource
    private SmsSendCmdExe smsSendCmdExe;

    @Resource
    private SmsUpBusinessDealExe smsUpBusinessDealExe;

    @Resource
    private SmsQryExe smsQryExe;

    @Resource
    private SmsConsumptionExe smsConsumptionExe;

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
    public List<SmsDTO> getSms(@NonNull SmsQry smsQry) {
        return smsQryExe.getSmsExe(smsQry);
    }

    /**
     * 消费短信数据
     *
     * @return
     */
    @Override
    public boolean dealSmsUpBusiness(Map<String, Object> contentMap) {
        return smsUpBusinessDealExe.dealSmsUpBusiness(contentMap);
    }

    @Override
    public void consumptionSms(@NonNull String identifies, @NonNull String content) {
        smsConsumptionExe.consumptionSms(identifies, content);
    }
}
