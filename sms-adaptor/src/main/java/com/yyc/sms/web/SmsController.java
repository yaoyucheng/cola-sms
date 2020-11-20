package com.yyc.sms.web;

import com.alibaba.cola.dto.SingleResponse;
import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.dto.SmsSendCmd;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.data.SmsResponseDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author yuchengyao
 */
@RestController
@RequestMapping("sms")
public class SmsController {

    @Resource
    private SmsServiceI smsServiceI;

    /**
     * 发送消息
     *
     * @param smsSendCmd
     * @return
     */
    @PostMapping("send")
    public SingleResponse<SmsResponseDTO> send(@Valid @RequestBody SmsSendCmd smsSendCmd) {
        return SingleResponse.of(smsServiceI.send(smsSendCmd));
    }

    /**
     * 获取信息状态
     *
     * @param smsUpExtendCodes
     * @return
     */
    @GetMapping
    public SingleResponse<List<SmsDTO>> get(@RequestParam String smsUpExtendCodes) {
        return SingleResponse.of(smsServiceI.getSmsByOutIds(smsUpExtendCodes.split(",")));
    }
}
