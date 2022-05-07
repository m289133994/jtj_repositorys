package com.jtj.dao;
import com.jtj.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/****
 * @Author: csh
 * @Description:SysUser的Dao
 *****/
@Repository
@Mapper
public interface SysUserMapper  {

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    SysUser queryUserByParameter(SysUser record);
}
