package com.jtj.service.impl;

import com.jtj.dao.SysIdentifyResourceMapper;
import com.jtj.model.SysIdentifyResource;
import com.jtj.service.SysIdentifyResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysIdentifyResourceServiceImpl implements SysIdentifyResourceService {
    // 注入持久层对象
    @Autowired
    private SysIdentifyResourceMapper sysIdentifyResourceMapper;


    @Override
    public void insert(SysIdentifyResource sysIdentifyResource) { sysIdentifyResourceMapper.insert(sysIdentifyResource); }

    @Override
    public void update(SysIdentifyResource sysIdentifyResource) { sysIdentifyResourceMapper.updateByPrimaryKey(sysIdentifyResource); }

    @Override
    public void delete(SysIdentifyResource sysIdentifyResource) { sysIdentifyResourceMapper.deleteByPrimaryKey(sysIdentifyResource.getId()); }

    @Override
    public SysIdentifyResource queryById(SysIdentifyResource sysIdentifyResource) {
        return sysIdentifyResourceMapper.selectByPrimaryKey(sysIdentifyResource.getId());
    }

    @Override
    public List<SysIdentifyResource> queryAll() {
        return sysIdentifyResourceMapper.selectAll();
    }
}
