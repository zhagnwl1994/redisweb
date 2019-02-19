package com.redisweb.redisweb;

import com.redisweb.redisweb.Entity.User;
import com.redisweb.redisweb.redisConf.RedisConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RediswebApplicationTests {

    @Autowired
    private  RedisConf redisConf;
    @Autowired
    private RedisTemplate redisTemplate ;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void contextLoads() {
        System.out.println(stringRedisTemplate);
        stringRedisTemplate.opsForValue().set("str1","pratice");
        System.out.println(  stringRedisTemplate.opsForValue().get("str1"));
        stringRedisTemplate.opsForValue().set("str2","pratice2",10, TimeUnit.SECONDS);
        System.out.println(stringRedisTemplate.opsForValue().get("str2"));//由于设置的是10秒失效，十秒之内查询有结果，十秒之后返回为null
        System.out.println(redisConf.getHost());

//        set void set(K key, V value, long offset);
//        该方法是用 value 参数覆写(overwrite)给定 key 所储存的字符串值，从偏移量 offset 开始
        stringRedisTemplate.opsForValue().set("key","hello world");
        stringRedisTemplate.opsForValue().set("key","redis",6);
        System.out.println("***************"+stringRedisTemplate.opsForValue().get("key"));

//        setIfAbsent Boolean setIfAbsent(K key, V value);  判断是否存在 key,若不存在则保存 key_value,若存在则返回false 不保存
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent("key1", "keyTest");
        System.out.println(aBoolean);

        /*multiSet void multiSet(Map<? extends K, ? extends V> m); 为多个键分别设置它们的值
        */
        Map <String,String>  multiMap = new ConcurrentHashMap<>();
        multiMap.put("s1","str1");
        multiMap.put("s2","str2");
        multiMap.put("s3","str3");
        multiMap.put("s4","str4");
        stringRedisTemplate.opsForValue().multiSet(multiMap);


        Map <String,Object>  multiMap2 = new ConcurrentHashMap<>();
        multiMap2.put("m1","multiMap21");
        multiMap2.put("m2","multiMap22");
        multiMap2.put("m3",new User("521"));

        redisTemplate.opsForValue().multiSet(multiMap2);


//        Collections.newHashSetFromMap

        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        set.add("m1");
        set.add("m2");
        set.add("m3");
        set.add("m4");
        List list = redisTemplate.opsForValue().multiGet(set);
        for (Object o : list) {
            System.out.println(o);
        }


    }

}
