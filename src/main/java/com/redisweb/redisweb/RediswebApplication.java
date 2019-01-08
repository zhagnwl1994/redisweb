package com.redisweb.redisweb;

import com.redisweb.redisweb.redisConf.RedisConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RediswebApplication {
    @Autowired
    private static RedisConf redisConf;

    public static void main(String[] args) {
        SpringApplication.run(RediswebApplication.class, args);
        System.out.println(redisConf.getHost());
    }
}
