package com.jtj.dao;

import com.jtj.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author csh
 * @date 2019/11/17 10:18:50
 * @description
 */
@Repository
@Mapper
public interface UserMapper {
   /* @Select("select * from test.user where name = #{name}")*/
    public User queryUserByName(String name);
   /* @Insert("insert into test.user(name,pwd,perms,salt_value) values(#{name},#{pwd},#{perms},#{saltValue})")*/
    public void insertUser(User user);
}
