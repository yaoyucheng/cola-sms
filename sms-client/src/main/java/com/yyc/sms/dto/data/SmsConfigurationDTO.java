package com.yyc.sms.dto.data;

import lombok.Data;

/**
 * @author yuchengyao
 */
@Data
public class SmsConfigurationDTO {

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

    /**
     * messageType
     */
    private String messageType;

    /**
     * queueName
     */
    private String queueName;

    public boolean filter(SmsConfigurationDTO qry) {

        return true;
    }

}
