package com._520.util;

import java.io.IOException;
import java.util.Properties;

/**
 *  配置文件
 */
public class PropertyMgr {

    private PropertyMgr(){}
    private static Properties properties = new Properties();

    static {
        try {
            // 加载配置文件
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  返回指定的key的对象
     */
    public static Object get(String key){
        return properties == null ? null : properties.get(key);
    }
    public static int getInt(String key){
        return properties == null ? 0 : Integer.valueOf((String)properties.get(key));
    }

    public static String getString(String key){
        return properties == null ? "" : (String)properties.get(key);
    }
}
