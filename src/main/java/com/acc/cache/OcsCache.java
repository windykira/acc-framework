package com.acc.cache;

/**
 * Created by windy on 2018/3/29.
 */
public class OcsCache {

    /*private static MemcachedClient cache;
    private static Logger logger = LoggerFactory.getLogger(OcsCache.class);
    private static int expire = 30 * 60 * 1000;

    private OcsCache() {
    }

    public static void add(String key, Object value) {
        cache.add(key, expire, value);
    }

    public static void add(String key, Object value, int expire) {
        cache.add(key, expire, value);
    }

    public static void put(String key, Object value) {
        cache.set(key, expire, value);
    }

    public static void put(String key, Object value, int expire) {
        cache.set(key, expire, value);
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    public static boolean exists(String key) {
        Object val = cache.get(key);
        return val != null;
    }

    public static void delete(String key) {
        cache.delete(key);
    }

    public static void append(String key, String value) {
        cache.append(1L, key, value);
    }

    public static void prepend(String key, String value) {
        cache.prepend(1L, key, value);
    }

    public static void expire(String key, int expire) throws RuntimeException {
        Object val = get(key);
        if (val == null) {
            throw new RuntimeException("key not in cache!");
        } else {
            cache.replace(key, expire, val);
        }
    }

    static {
        String host = SystemConfig.getProperty("ACC_FRAMEWORK_OCS_HOST");
        String port = SystemConfig.getProperty("ACC_FRAMEWORK_OCS_PORT");
        String userName = SystemConfig.getProperty("ACC_FRAMEWORK_OCS_USERNAME");
        String password = SystemConfig.getProperty("ACC_FRAMEWORK_OCS_PASSWORD");
        logger.debug("hosts:" + host + ", port:" + port + ", username:" + userName + ", password:" + password);

        try {
            if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(password)) {
                cache = new MemcachedClient(AddrUtil.getAddresses(host + ":" + port));
            } else {
                AuthDescriptor e = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler(userName, password));
                cache = new MemcachedClient((new ConnectionFactoryBuilder()).setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                        .setAuthDescriptor(e).build(), AddrUtil.getAddresses(host + ":" + port));
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }*/
}
