package com.yyc.sms.handler;

/**
 * @author yuchengyao
 */
public interface UserContextI {

    /**
     * 获取用户标识
     *
     * @return
     */
    String getId();

    /**
     * 获取用户名称
     *
     * @return
     */
    String getUserName();
}
