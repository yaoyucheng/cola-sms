package com.yyc.sms.domain.sms.domainservice;

import com.alibaba.cola.exception.BizException;
import com.alicom.mns.tools.DefaultAlicomMessagePuller;
import com.alicom.mns.tools.MessageListener;
import com.aliyuncs.exceptions.ClientException;
import com.yyc.sms.domain.util.StringUtils;
import com.yyc.sms.expetion.ErrorCode;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

/**
 * sms 接收容器
 *
 * @author yuchengyao
 */
@Slf4j
@Data
@Builder
public class SmsReceiverListenerContainer {

    private String accessKeyId;

    private String accessKeySecret;

    private String messageType;

    private String queueName;

    private MessageListener messageListener;

    /**
     * 线程组
     */
    private DefaultAlicomMessagePuller puller;

    /**
     * 线程初始化
     */
    public SmsReceiverListenerContainer initMessageListener() {

        puller = new DefaultAlicomMessagePuller();

        //设置异步线程池大小及任务队列的大小，还有无数据线程休眠时间
        puller.setConsumeMinThreadSize(6);
        puller.setConsumeMaxThreadSize(16);
        puller.setThreadQueueSize(200);
        puller.setPullMsgThreadSize(1);

        //和服务端联调问题时开启,平时无需开启，消耗性能
        puller.openDebugLog(false);

        if (!StringUtils.isAllNotEmpty(this.accessKeyId, this.accessKeySecret, this.messageType, this.queueName)) {

            //  短信配置异常
            throw new BizException(ErrorCode.SMS_CONFIG_PARAMETER_EXCEPTION, "短信参数异常");
        }

        if (this.messageListener == null) {
            throw new BizException(ErrorCode.SMS_RECEIVER_HANDLE_NULL, "短信处理容器构造");
        }

        try {
            puller.startReceiveMsg(this.accessKeyId, this.accessKeySecret, this.messageType, this.queueName, this.messageListener);
        } catch (ClientException e) {
            log.error("客户端异常", e);
            e.printStackTrace();
        } catch (ParseException e) {
            log.error("解析异常", e);
            e.printStackTrace();
        }

        return this;
    }

    public void stop() {
        this.puller.stop();
    }
}
