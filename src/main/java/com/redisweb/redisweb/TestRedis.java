package com.redisweb.redisweb;

import com.redisweb.redisweb.redisConf.RedisConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

public class TestRedis {

    @Autowired
    private static RedisConf redisConf;

    public static void main(String[] args) {

        System.out.println(redisConf.getHost());
    }

}
