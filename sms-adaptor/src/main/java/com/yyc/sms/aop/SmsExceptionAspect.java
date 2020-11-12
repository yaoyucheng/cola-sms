package com.yyc.sms.aop;

import com.yyc.sms.expetion.handler.DefaultExceptionHandlerI;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 短信异常拦截
 *
 * @author yuchengyao
 */
@Slf4j
@Aspect
@Component
public class SmsExceptionAspect {

    @Autowired
    private DefaultExceptionHandlerI defaultExceptionHandlerI;


    //  异常处理......
}
