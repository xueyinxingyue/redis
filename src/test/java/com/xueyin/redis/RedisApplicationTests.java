package com.xueyin.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Test
    void contextLoads() {
        //Jedis中的方法与Redis中的命令一致

        //创建连接池
        JedisPool pool = new JedisPool("localhost",6379);
        //获取链接
        Jedis jedis = pool.getResource();
        //设置Redis密码     当Redis设置了密码才需要下面设置
        jedis.auth("admin");

        //保存一个namekey，值为张三数据
//        jedis.set("name","张三");

        //获取name key数据
        String name = jedis.get("name");

        //设置过期时间
        jedis.expire("name",20);

        System.out.println(name);
        //查看过期时间
        System.out.println(jedis.ttl("name"));
    }

    @Autowired
    private JedisPool jedisPool;

    @Test
    void test1(){
        Jedis resoure = jedisPool.getResource();
        resoure.set("sex","man");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    void test2(){
        //保存一个age key，值为30数据
        redisTemplate.opsForValue().set("age","30",1000, TimeUnit.SECONDS);

        System.out.println(redisTemplate.opsForValue().get("age"));

        System.out.println(redisTemplate.getExpire("age"));
    }

    //引入工具包
    @Autowired
    private RedisUtils redisUtils;
    @Test
    void test3(){
        System.out.println(redisUtils.ttl("age"));
    }
}
