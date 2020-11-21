package com.yyc.sms.status;

import com.yyc.sms.Status;

/**
 * @author yuchengyao
 */

public enum DataStatus implements Status {

    NEW("20","新增"),

    DELETE("21","删除"),
    ;


    private String code;

    private String message;


    DataStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
