package com.yyc.sms.dto.data;

import lombok.Builder;
import lombok.Data;

/**
 * @author yuchengyao
 */
@Data
@Builder
public class SmsResponseDTO {

    private String requestId;

    private String bizId;

    private String code;

    private String message;

    /**
     * 短信唯一标识
     */
    private String identifies;
}
