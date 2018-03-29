package com.acc.cache;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by windy on 2018/3/29.
 */
public class TestCache {

    @Test
    public void test(){

        //Cache.set("test","test");
        Object o = Cache.get("test");
        //Cache.delete("test");
        assert o != null;
    }
}
