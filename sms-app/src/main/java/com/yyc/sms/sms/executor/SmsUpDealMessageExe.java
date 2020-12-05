package com.yyc.sms.sms.executor;

import com.alicom.mns.tools.MessageListener;
import com.aliyun.mns.model.Message;
import com.google.gson.Gson;
import com.yyc.sms.api.SmsServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchengyao
 */
@Slf4j
@Component
public class SmsUpDealMessageExe implements MessageListener {

    private Gson gson = new Gson();

    @Resource
    private SmsServiceI smsServiceI;

    /**
     * 消息处理成功，返回true, SDK将调用MNS的delete方法将消息从队列中删除掉
     *
     * @param message
     * @return
     */
    @Override
    public boolean dealMessage(Message message) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //消息的几个关键值
        log.info("message receiver t ime from mns: {}" + format.format(new Date()));
        log.info("message handle: {}" + message.getReceiptHandle());
        log.info("message body: {}" + message.getMessageBodyAsString());
        log.info("message id: {}" + message.getMessageId());
        log.info("message dequeue count: {}" + message.getDequeueCount());
        log.info("Thread: {}" + Thread.currentThread().getName());

        try {
            Map<String, Object> contentMap = gson.fromJson(message.getMessageBodyAsString(), HashMap.class);

            /**
             * 消费短信上行数据
             *
             * 1、这里开始编写您的业务代码
             * 2、根据文档中具体的消息格式进行消息体的解析
             */
            return smsServiceI.dealSmsUpBusiness(contentMap);

        } catch (com.google.gson.JsonSyntaxException e) {
            log.error("error_json_format:" + message.getMessageBodyAsString(), e);
            //理论上不会出现格式错误的情况，所以遇见格式错误的消息，只能先delete,否则重新推送也会一直报错
            return true;
        } catch (Throwable e) {
            //您自己的代码部分导致的异常，应该return false,这样消息不会被delete掉，而会根据策略进行重推
            log.error("error",e);
            return false;
        }

    }
}
