package com.yyc.sms.sms.executor;

import com.alibaba.cola.exception.BizException;
import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.qry.SmsQry;
import com.yyc.sms.expetion.ErrorCode;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yuchengyao
 */
@Slf4j
@Component
public class SmsUpBusinessDealExe {

    /**
     * 短信接收号码
     */
    private static final String CONTENT_MAP_PHONE_NUMBER = "phone_number";

    /**
     * 短信内容
     */
    private static final String CONTENT_MAP_CONTENT = "content";

    /**
     * 短信签名
     */
    private static final String CONTENT_MAP_SIGN_NAME = "sign_name";

    /**
     * 时间
     */
    private static final String CONTENT_MAP_SEND_TIME = "send_time";

    /**
     * 扩展码
     */
    private static final String CONTENT_MAP_DEST_CODE = "dest_code";

    /**
     * 消息序列ID
     */
    private static final String CONTENT_MAP_SEQUENCE_ID = "sequence_id";

    @Resource
    private SmsServiceI smsServiceI;

    /**
     * phone_number	String	短信接收号码	13000000000
     * content	String	短信内容	true
     * sign_name	String	短信签名	【阿里云】
     * send_time	String	时间	20150101120000
     * dest_code	String	扩展码	123456
     * sequence_id	Double	消息序列ID	123456
     *
     * @param contentMap 上行短信消息SmsUp
     * @return
     */
    public boolean dealSmsUpBusiness(@NonNull Map<String, Object> contentMap) {

        //  短信接收号码
        String phoneNumber = (String) contentMap.get(CONTENT_MAP_PHONE_NUMBER);

        //  短信内容
        String content = (String) contentMap.get(CONTENT_MAP_CONTENT);

        //  扩展码
        String destCode = (String) contentMap.get(CONTENT_MAP_DEST_CODE);

        SmsDTO smsDTO = getSmsDTO(destCode, phoneNumber);

        return false;
    }

    private SmsDTO getSmsDTO(String destCode, String phoneNumber) {

        List<SmsDTO> sms = smsServiceI.getSms(buildSmsQry(destCode));

        if (sms == null || sms.isEmpty()) {
            //  数据异常
            throw new BizException(ErrorCode.SMS_UP_DATA_NULL, "基础啊数据为空");
        }

        //  过滤非上行号码数据
        sms.stream().filter(value -> value.getPhoneNumberJson().indexOf(phoneNumber) > -1).collect(Collectors.toList());

        if (sms == null || sms.isEmpty()) {
            //  数据异常
            throw new BizException(ErrorCode.SMS_UP_DATA_EXCEPTION, "基础啊数据异常");
        }

        if (sms.size() > 1) {
            //  数据重复，数据做过滤

        }
        return sms.get(0);
    }

    /**
     * 构建查询参数
     *
     * @return
     */
    private SmsQry buildSmsQry(@NonNull String destCode) {

        return SmsQry.builder()
                .smsUpExtendCode(destCode)
                .build();
    }
}
