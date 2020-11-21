package com.yyc.sms.sms.context;

import com.yyc.sms.handler.UserContextI;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author yuchengyao
 */
@Data
@Component
public class UserContext implements UserContextI {

    /**
     * 用户标识
     */
    private String id = "96458f6949784d729bb98c9f8a94f885";

    /**
     * 用户名称
     */
    private String userName = "sys";

}
