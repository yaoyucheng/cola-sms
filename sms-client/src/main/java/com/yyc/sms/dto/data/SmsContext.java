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
     * accessKey
     */
    private String accessKey;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

}
