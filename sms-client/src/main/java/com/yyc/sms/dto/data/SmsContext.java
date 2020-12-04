package com.yyc.sms.dto.data;

import lombok.Builder;
import lombok.Data;

/**
 * @author 10916
 */
@Data
@Builder
public class SmsContext {

    /**
     * 产品名称:云通信短信API产品
     */
    public static final String PRODUCT = "Dysmsapi";

    /**
     * 产品域名
     */
    private String domain;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

}
