package com.wb.system.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisProxy {

    @Autowired
    JedisCluster jedisCluster;

    public String getString(String key) {
        try {
            return jedisCluster.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String setString(String key, String value) {
        try {
            return jedisCluster.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
