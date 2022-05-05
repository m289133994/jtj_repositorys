package com.jtj.service.impl;

import com.jtj.mapper.UserMapper;
import com.jtj.pojo.User;
import com.jtj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author csh
 * @date 2019/11/17 10:33:55
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
