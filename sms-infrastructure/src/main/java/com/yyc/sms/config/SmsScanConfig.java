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
        "com.yyc.sms.sms",
        "com.yyc.sms.configuration",
        "com.gitee.sunchenbin.mybatis.actable.manager.*"
})
@MapperScan(value = {
        "com.gitee.sunchenbin.mybatis.actable.dao.*",
        "com.yyc.sms.sms",
        "com.yyc.sms.configuration"
})
public class SmsScanConfig {

}