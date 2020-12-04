package com.yyc.sms.dto.qry;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchengyao
 */
@Data
@Builder
public class SmsQry {

    /**
     * 短信上行code
     */
    private String smsUpExtendCode;

    /**
     * 唯一标识
     */
    private String identifies;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 短信唯一标识code 集合
     */
    private List<String> identifiesList = new ArrayList<>();
}
