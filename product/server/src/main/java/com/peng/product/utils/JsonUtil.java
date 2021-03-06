package com.peng.product.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
           String string =  objectMapper.writeValueAsString(object);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * json转对象
     *
     * @param string，classType
     * @return
     */
    public static Object fromJson(String string, Class classType) {
        try {
            return objectMapper.readValue(string, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
