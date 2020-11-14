package com.yyc.sms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 10916
 */
@Configuration
@ComponentScan(value = {
        "com.yyc.sms.domain.sms.domainservice",
        "com.yyc.sms.sms"
})
@MapperScan("com.yyc.sms.sms")
public class SmsScanConfig {
}