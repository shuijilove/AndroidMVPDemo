package com.zhj.androidmvpdemo.util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Fastjson工具类
 * Created by hjzhang on 2016/2/4.
 */
public class FastJsonTools {
    /**
     * 用fastjson 将json字符串解析为一个 JavaBean
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T>T getJson(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString,cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * JavaBean转为String
     * @param obj
     * @return
     */
    public static String toJson(Object obj){
        String jsonStr =  JSON.toJSONString(obj);
        return  jsonStr;
    }

    /**
     * 用fastjson 将json字符串 解析成为一个 List 及 List
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static List getArrayJson(String jsonString, Class cls) {
        List list = new ArrayList();
        try {
            list = JSON.parseArray(jsonString,cls);
        } catch (Exception e) {
        }
        return list;
    }
}
