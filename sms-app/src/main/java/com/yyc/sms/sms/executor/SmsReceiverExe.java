package com.yyc.sms.sms.executor;

import com.alicom.mns.tools.MessageListener;
import com.gitee.sunchenbin.mybatis.actable.manager.handler.StartUpHandler;
import com.yyc.sms.api.SmsConfigurationServiceI;
import com.yyc.sms.api.SmsServiceI;
import com.yyc.sms.domain.sms.domainservice.SmsReceiverListenerContainer;
import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchengyao
 */
@Component
public class SmsReceiverExe {

    @Resource
    private StartUpHandler startUpHandler;

    @Resource
    private SmsServiceI smsServiceI;

    @Resource
    private SmsConfigurationServiceI smsConfigurationServiceI;

    @Resource
    private MessageListener messageListener;

    /**
     * 执行器
     */
    private List<SmsReceiverListenerContainer> smsReceiverListenerContainers = new ArrayList<>();

    /**
     * 配置环境
     */
    private List<SmsConfigurationDTO> smsConfigurations = new ArrayList<>();

    public void initSmsReceiverContainer() {

        if (checkInitializationAndInitConfiguration()) {
            restartSmsReceiverContainer();
        }
    }
    
    /**
     * 启动运行
     * 短信接收者
     */
    @PostConstruct
    private void smsReport() {

        //  init config

        //  初始化 SmsReceiverContainer
        initSmsReceiverContainer();
    }

    private boolean checkInitializationAndInitConfiguration() {

        //  check config
        boolean checkFlag = smsConfigurationServiceI.checkInitialization();

        if (checkFlag) {
            initConfiguration();
        }

        return checkFlag;
    }

    private void initConfiguration() {
        this.smsConfigurations = smsConfigurationServiceI.getConfiguration(SmsConfigurationQry.builder().build());
    }

    ;

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

    /**
     * 重启服务
     *
     * @return
     */
    private void restartSmsReceiverContainer() {

        stopSmsReceiverContainer();

        startSmsReceiverContainer();
    }

    /**
     * 启动服务
     */
    private void startSmsReceiverContainer() {

        this.smsConfigurations.forEach(value -> {
            smsReceiverListenerContainers.add(
                    buildSmsReceiverContainer(
                            value.getAccessKey(),
                            value.getAccessKeySecret(),
                            value.getMessageType(),
                            value.getQueueName(),
                            messageListener));
        });
    }

    /**
     * 关闭服务
     */
    private void stopSmsReceiverContainer() {
        this.smsReceiverListenerContainers.forEach(value -> {
            value.stop();
        });

        smsReceiverListenerContainers.clear();
    }

}
