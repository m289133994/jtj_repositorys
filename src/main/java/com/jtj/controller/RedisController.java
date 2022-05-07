package com.jtj.controller;

import com.jtj.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//测试代码，可以直接删除或者忽略
@RestController
@RequestMapping("/Dog")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @Cacheable(key = "'allDogName'",value = "selectList")
    @GetMapping(value = "getAllDogName")
    public List<String> getAllDogName(){
        return redisService.getAllDogName();
    }


}

