package com.yyc.sms.dto.qry;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Resource;
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
     * 短信唯一标识code 集合
     */
    private List<String> identifiesList;
}