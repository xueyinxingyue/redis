package com.xueyin.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
    /**
     * jedis连接池
     *
     * @param jedisProperties
     * @return
     */
    @Bean
    public JedisPool jedisPool(JedisProperties jedisProperties) {
        JedisPoolConfig config = new JedisPoolConfig();

        return new JedisPool(config, jedisProperties.getHost(),
                jedisProperties.getPort(),
                jedisProperties.getTimeout(),
                jedisProperties.getPassword());
    }
}