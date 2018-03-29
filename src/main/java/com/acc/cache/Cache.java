package com.acc.cache;

import com.acc.config.SystemConfig;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;

/**
 * memcached缓存操作。
 * @author maxl。
 */
public class Cache {

    private static MemcachedClient memcached = null;
    private static int expire = 30 * 60;

    static {
        String host = SystemConfig.getProperty("ACC_FRAMEWORK_CACHE_HOST");
        String port = SystemConfig.getProperty("ACC_FRAMEWORK_CACHE_PORT");
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(host + ":" + port));
        builder.setConnectionPoolSize(50);//连接池大小
        builder.setFailureMode(true);//宕机报警
        try {
            memcached = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void set(String key, Object value) {
        try {
            memcached.set(key, expire, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void set(String key, Object value, int minutes) {
        try {
            memcached.set(key, minutes * 60, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        try {
            return memcached.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(String key) {
        try {
            if (memcached != null) {
                memcached.delete(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
