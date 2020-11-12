package com.yyc.sms.aop;

import com.alibaba.cola.exception.BizException;
import com.yyc.sms.api.SmsContextI;
import com.yyc.sms.domain.util.StringUtils;
import com.yyc.sms.expetion.ErrorCode;
import com.yyc.sms.dto.data.SmsContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuchengyao
 */
@Slf4j
@Aspect
@Component
public class SmsContentAspect {

    @Resource
    private SmsContextI smsContextI;

    /**
     * 定义切入点，切入点为 com.yyc.sms.aop.web.SmsController 中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.yyc.sms.aop.web.SmsController.*(..)))")
    public void SmsContentAspect() {
        //  do nothing
    }

    /**
     * @description 在连接点执行之前执行的通知
     */
    @Before("SmsContentAspect()")
    public void doBeforeGame(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //  短信接口中 Header 中的参数接收
        String smsAccessKey = request.getHeader("sms-access-key");
        String smsAccessKeySecret = request.getHeader("sms-access-key-secret");
        String smsDomain = request.getHeader("sms-domain");
        String smsSignName = request.getHeader("sms-sign-name");
        String smsTemplateCode = request.getHeader("sms-template-code");

        //  参数校验
        checkParameter(smsAccessKey, smsAccessKeySecret, smsDomain, smsSignName, smsTemplateCode);

        //  初始化当前线程的短信环境
        smsContextI.setSmsContent(
                SmsContext.builder()
                        .accessKey(smsAccessKey)
                        .accessKeySecret(smsAccessKeySecret)
                        .domain(smsDomain)
                        .signName(smsSignName)
                        .templateCode(smsTemplateCode)
                        .build());
    }

    /**
     * @description 在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("SmsContentAspect()")
    public void doAfterGame() {
        //  清除请求中的短信上下文
        smsContextI.clean();
    }

    /**
     * 参数校验
     *
     * @param strings 参数
     */
    private void checkParameter(String... strings) {
        //  所有参数不可以为空
        if (!StringUtils.isAllNotEmpty(strings)) {
            //  参数错误 报错
            throw new BizException(ErrorCode.SMS_CONFIG_PARAMETER_EXCEPTION, "短信参数异常");
        }
    }
}
