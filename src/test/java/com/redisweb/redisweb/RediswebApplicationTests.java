package com.redisweb.redisweb;

import com.redisweb.redisweb.redisConf.RedisConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RediswebApplicationTests {

    @Autowired
    private  RedisConf redisConf;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void contextLoads() {
        System.out.println(stringRedisTemplate);
//        stringRedisTemplate.opsForValue().set("k","haha");

        System.out.println(redisConf.getHost());
    }

}
