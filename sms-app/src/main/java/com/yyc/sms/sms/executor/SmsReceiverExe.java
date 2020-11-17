package com.yyc.sms.sms.executor;

import com.alicom.mns.tools.MessageListener;
import com.yyc.sms.domain.sms.domainservice.SmsReceiverListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchengyao
 */
@Component
public class SmsReceiverExe {

    @Autowired
    private SmsReceiverDealMessageExe smsReceiverDealMessageExe;

    /**
     *
     */
    private List<SmsReceiverListenerContainer> smsReceiverListenerContainers = new ArrayList<>();

    /**
     * 启动运行
     * 短信接收者
     */
    @PostConstruct
    public void smsReport() {

        //  init config

        //  初始化 SmsReceiverContainer

//        smsReceiverListenerContainers.add(buildSmsReceiverContainer());
    }

    void initConfig() {

    }

    /**
     * 构造
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @param messageType
     * @param queueName
     * @param messageListener
     * @return
     */
    private SmsReceiverListenerContainer buildSmsReceiverContainer(String accessKeyId,
                                                                   String accessKeySecret,
                                                                   String messageType,
                                                                   String queueName,
                                                                   MessageListener messageListener) {

        return SmsReceiverListenerContainer.builder()
                .accessKeyId(accessKeyId)
                .accessKeySecret(accessKeySecret)
                .messageType(messageType)
                .queueName(queueName)
                .messageListener(messageListener)
                .build()
                .initMessageListener();
    }
}
