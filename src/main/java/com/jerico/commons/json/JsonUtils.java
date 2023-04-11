package com.jerico.commons.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * json工具类-封装jackson
 *
 * @author hairu
 * @date 2023-4-5 19:51
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json字符串
     * @param t  对象参数
     * @return java.lang.String json字符串
     * @author hairu
     * @date 2023-4-5 19:57
     */
    public static <T> String objToJson(T t) throws JsonProcessingException {
        return objectMapper.writeValueAsString(t);
    }

    /**
     * json字符串转对象
     * @param json json字符串
     * @param cls 对象类
     * @return T 对象类
     * @author hairu
     * @date 2023-4-5 20:33
     */
    public static <T> T jsonToObj(String json, Class<T> cls) throws JsonProcessingException {
        return objectMapper.readValue(json, cls);
    }


    /**
     * json字符串转List
     * @param jsonStr json字符串
     * @param cls 实体类
     * @return java.util.List<T> List集合
     * @author hairu
     * @date 2023-4-5 20:24
     */
    public static <T> List<T> jsonToList(String jsonStr, Class<T> cls) throws JsonProcessingException {
        return objectMapper.readValue(jsonStr, getCollectionType(List.class, cls));
    }

    /**
     * 获取泛型的Collection Type
     * @param collectionType 泛型的collection
     * @param elementClass 实体Bean
     * @return com.fasterxml.jackson.databind.JavaType java类型
     * @author hairu 
     * @date 2023-4-5 20:22
     */
    private static JavaType getCollectionType(Class<?> collectionType, Class<?>... elementClass) {
        return objectMapper.getTypeFactory().constructParametricType(collectionType, elementClass);
    }
}
