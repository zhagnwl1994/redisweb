package com.redisweb.redisweb;

import com.redisweb.redisweb.redisConf.RedisConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableCaching //开启注解驱动的缓存管理
@SpringBootApplication
public class RediswebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RediswebApplication.class, args);
    }

//    @Bean
//    public RedisTemplate redisTemplate(){
//        return new RedisTemplate();
//    }
}
