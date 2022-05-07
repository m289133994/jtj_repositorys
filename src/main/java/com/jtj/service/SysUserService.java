package com.jtj.service;

import com.jtj.model.SysUser;

import java.util.List;

/****
 * @Author: csh
 * @Description:SysUser业务层接口
 *****/
public interface SysUserService {

    public void insert(SysUser sysUser);

    public void update(SysUser sysUser);

    public void delete(SysUser sysUser);

    public SysUser queryById(SysUser sysUser);

    public List<SysUser> queryAll();

    public SysUser queryUserByParameter(SysUser sysUser);

}
