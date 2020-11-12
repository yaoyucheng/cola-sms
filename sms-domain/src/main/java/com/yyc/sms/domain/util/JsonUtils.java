package com.yyc.sms.domain.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import java.lang.reflect.Type;

/**
 * @author 10916
 */
public class JsonUtils {

    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            .setLongSerializationPolicy(LongSerializationPolicy.STRING)
            .create();

    public static String toString(Object o) {
        return gson.toJson(o);
    }

    public static <T> T parse(String jsonData, Class<T> type) {
        return gson.fromJson(jsonData, type);
    }

    public static <T> T parse(String jsonData, Type typeOfT) {
        return gson.fromJson(jsonData, typeOfT);
    }
}
