package com.yyc.sms.domain.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author yuchengyao
 */
public class StringUtils {

    public static boolean isAllNotEmpty(String... strings) {
        return Arrays.stream(strings)
                .filter(x -> org.apache.commons.lang3.StringUtils.isEmpty(x))
                .collect(Collectors.toList())
                .isEmpty();
    }
}
