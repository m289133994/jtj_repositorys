package com.jtj.service.impl;

import com.jtj.dao.SysUserMapper;
import com.jtj.model.SysUser;
import com.jtj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author: csh
 * @Description:SysUser业务层接口实现类
 *****/
@Service
public class SysUserServiceImpl implements SysUserService {

    // 注入持久层对象
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public void insert(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void update(SysUser sysUser) { sysUserMapper.updateByPrimaryKey(sysUser); }

    @Override
    public void delete(SysUser sysUser) { sysUserMapper.updateByPrimaryKey(sysUser); }

    @Override
    public SysUser queryById(SysUser sysUser) { return sysUserMapper.selectByPrimaryKey(sysUser.getUserId()); }

    @Override
    public List<SysUser> queryAll() { return sysUserMapper.selectAll(); }

    @Override
    public SysUser queryUserByParameter(SysUser sysUser) { return sysUserMapper.queryUserByParameter(sysUser); }

}
