package com.redisweb.redisweb.Controller;

import com.redisweb.redisweb.Entity.Book;
import com.redisweb.redisweb.Entity.Dog;
import com.redisweb.redisweb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class MyRedis {
//RedisTemplate中定义了5种数据结构操作
//
//redisTemplate.opsForValue();　　//操作字符串
//redisTemplate.opsForHash();　　 //操作hash
//redisTemplate.opsForList();　　 //操作list
//redisTemplate.opsForSet();　　  //操作set
//redisTemplate.opsForZSet();　 　//操作有序set


//StringRedisTemplate常用操作
//复制代码
//stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
//
//stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
//
//stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
//
//stringRedisTemplate.boundValueOps("test").increment(1);//val +1
//
//stringRedisTemplate.getExpire("test")//根据key获取过期时间
//
//stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
//
//stringRedisTemplate.delete("test");//根据key删除缓存
//
//stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
//
//stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
//
//stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
//
//stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
//
//stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/getname")
    public String getName() {
        System.out.println(stringRedisTemplate);
        System.out.println(redisTemplate);

        stringRedisTemplate.opsForValue().set("name", "李四", 1L, TimeUnit.MINUTES);
        String name = stringRedisTemplate.opsForValue().get("name");
        redisTemplate.opsForValue().set("dog", new Dog("jerry", 3));
        Dog dog = (Dog) redisTemplate.opsForValue().get("dog");
        return "My name is" + name + dog.toString();
    }

    @GetMapping(value = "/getBooks")
    @Cacheable(value = {"CACHE_BOOK"}, key = "BookList")
//    public List<Book> getBooks(String username, int language) {
    public List<Book> getBooks() {
        // balabalabala...里面的代码不重要
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("线性代数", 1));
        bookList.add(new Book("毛概", 1));

        return bookList;
    }


    /**
     * 先用id生成key，在用这个key查询redis中有无缓存到对应的值
     * <p>
     * 若无缓存，则执行方法selectById，并把方法返回的值缓存到redis
     * <p>
     * 若有缓存，则直接把redis缓存的值返回给用户，不执行方法
     */
    @PostMapping("/selectById")
    @Cacheable(cacheNames = "user", key = "#id")
    public User selectById(String id) {
        //直接new一个给定id的用户对象，来返回给用户
        return new User(id, "redisOnly", "password");
    }

    //    若想删除redis缓存的所有用户数据，可以把注解改成@CacheEvict(cacheNames="user", allEntries=true)
    @CacheEvict(cacheNames = {"user"}, key = "#id")
    @PostMapping("/delete")
    public String delete(String id) {

        return "delete";
    }

    @CacheEvict(cacheNames = {"user"}, allEntries = true)
    @PostMapping("/deleteall")
    public String deleteall() {

        return "deleteAll";
    }
}
