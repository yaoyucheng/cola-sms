package com.yyc.sms.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yyc.sms.status.DataStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserContextI userContextI;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("come to insert fill .........");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", userContextI.getId(), metaObject);
        this.setFieldValByName("status", Integer.parseInt(DataStatus.NEW.getCode()), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("come to update fill .......");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userContextI.getId(), metaObject);
    }
}
