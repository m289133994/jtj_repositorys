package com.jtj.dao;

import com.jtj.model.SysIdentifyResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysIdentifyResourceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysIdentifyResource record);

    SysIdentifyResource selectByPrimaryKey(Integer id);

    List<SysIdentifyResource> selectAll();

    int updateByPrimaryKey(SysIdentifyResource record);
}