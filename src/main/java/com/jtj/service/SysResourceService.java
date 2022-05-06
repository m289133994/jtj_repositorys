package com.jtj.service;

import com.jtj.model.SysResource;

import java.util.List;

/****
 * @Author: csh
 * @Description:SysResource业务层接口
 *****/
public interface SysResourceService {

    public void insert(SysResource sysResource);

    public void update(SysResource sysResource);

    public void delete(SysResource sysResource);

    public SysResource queryById(SysResource sysResource);

    public List<SysResource> queryAll();

}
