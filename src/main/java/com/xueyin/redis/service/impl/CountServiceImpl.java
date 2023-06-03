package com.xueyin.redis.service.impl;

import com.xueyin.redis.RedisUtils;
import com.xueyin.redis.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Integer count(Integer id){
        String sid = id.toString();
        //见Redis中存储的访问量+1
        redisUtils.incr(sid);
        return Integer.valueOf(redisUtils.get(sid));
    }
}
