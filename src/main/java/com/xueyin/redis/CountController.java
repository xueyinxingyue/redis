package com.xueyin.redis;

import com.xueyin.redis.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    @Autowired
    private CountService service;

    @GetMapping("count/{id}")
    public Integer count(@PathVariable Integer id){
        return service.count(id);
    }
}
