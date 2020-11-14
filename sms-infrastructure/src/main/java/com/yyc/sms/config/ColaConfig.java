package com.yyc.sms.config;

import com.alibaba.cola.boot.SpringBootstrap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for COLA framework
 *
 * @author yuchengyao
 */

@Configuration
public class ColaConfig {

    @Bean(initMethod = "init")
    public SpringBootstrap bootstrap() {
        SpringBootstrap bootstrap = new SpringBootstrap();
        return bootstrap;
    }

}
