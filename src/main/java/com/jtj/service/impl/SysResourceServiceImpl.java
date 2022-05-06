package com.jtj.service.impl;

import com.jtj.dao.SysResourceMapper;
import com.jtj.model.SysResource;
import com.jtj.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author: csh
 * @Description:SysResource业务层接口实现类
 *****/
@Service
public class SysResourceServiceImpl implements SysResourceService {

    // 注入持久层对象
    @Autowired
    private SysResourceMapper sysResourceMapper;


    @Override
    public void insert(SysResource sysResource) { sysResourceMapper.insert(sysResource); }

    @Override
    public void update(SysResource sysResource) { sysResourceMapper.updateByPrimaryKey(sysResource); }

    @Override
    public void delete(SysResource sysResource) { sysResourceMapper.updateByPrimaryKey(sysResource); }

    @Override
    public SysResource queryById(SysResource sysResource) { return sysResourceMapper.selectByPrimaryKey(sysResource.getResourceId()); }

    @Override
    public List<SysResource> queryAll() { return sysResourceMapper.selectAll(); }
}
