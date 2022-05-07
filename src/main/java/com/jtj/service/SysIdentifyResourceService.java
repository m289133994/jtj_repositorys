package com.jtj.service;

import com.jtj.model.SysIdentifyResource;

import java.util.List;

public interface SysIdentifyResourceService {
    public void insert(SysIdentifyResource sysIdentifyResource);

    public void update(SysIdentifyResource sysIdentifyResource);

    public void delete(SysIdentifyResource sysIdentifyResource);

    public SysIdentifyResource queryById(SysIdentifyResource sysIdentifyResource);

    public List<SysIdentifyResource> queryAll();
}
