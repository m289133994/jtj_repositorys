package com.jtj.service.impl;

import com.jtj.service.RedisService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {


    @Override
    public List<String> getAllDogName() {
        //这里我没有连接数据库，所以模拟一个方法当作从数据库中取数据
        List<String> list = getAllDogNameFromMySQL();
        return list;
    }


    //这里我没有连接数据库，所以模拟一个方法当作从数据库中取数据
    public List<String> getAllDogNameFromMySQL(){
        //下面是我自己造的,为了知道有没有从数据库取数据，在控制台打印一下
        System.out.println("=============================从mysql数据库取数据");
        List<String> list = Arrays.asList("A陈Dog", "BDog", "CDog", "DDog");
        System.out.println("==================================取数据完成");
        return list;
    }

}


