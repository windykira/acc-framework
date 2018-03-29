package com.acc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties配置文件操作。
 * @author maxl。
 */
public class SystemConfig {

    public static String getProperty(String key){

        Properties properties = new Properties();
        InputStream inputStream = SystemConfig.class.getClassLoader().getResourceAsStream("env.properties");
        try {
            properties.load(inputStream);
            return (String) properties.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
