package com.yyc.sms.domain.sms.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 10916
 */
@Builder
@Data
public class SmsResponse {

    private String requestId;

    private String bizId;

    private String code;

    private String message;
}
