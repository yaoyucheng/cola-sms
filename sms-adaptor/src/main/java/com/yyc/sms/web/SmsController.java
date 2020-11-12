package com.yyc.sms.web;

import com.alibaba.cola.dto.SingleResponse;
import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author yuchengyao
 */
@RestController
@RequestMapping("sms")
public class SmsController {

    @Resource
    private SmsServiceI smsServiceI;

    /**
     * @param smsSendCmd
     * @return
     */
    @PostMapping("send")
    public SingleResponse<SmsResponseDTO> send(@Valid @RequestBody SmsSendCmd smsSendCmd) {
        return SingleResponse.of(smsServiceI.send(smsSendCmd));
    }
}
