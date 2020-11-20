package com.yyc.sms.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 基础数据对象处理器
 *
 * @author yuchengyao
 */
@Component
@Slf4j
public class BaseObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("come to insert fill .........");
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("come to update fill .......");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
