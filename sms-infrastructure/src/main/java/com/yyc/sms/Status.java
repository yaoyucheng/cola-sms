package com.yyc.sms;

/**
 * 状态接口
 *
 * @author yuchengyao
 */
public interface Status {

    /**
     * 获取code
     *
     * @return
     */
    String getCode();

    /**
     * 获取信息
     *
     * @return
     */
    String getMessage();
}
