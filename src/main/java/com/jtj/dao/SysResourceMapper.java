package com.jtj.dao;
import com.jtj.model.SysResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/****
 * @Author: csh
 * @Description:SysResource的Dao
 *****/
@Repository
@Mapper
public interface SysResourceMapper  {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResource record);

    SysResource selectByPrimaryKey(Integer resourceId);

    List<SysResource> selectAll();

    int updateByPrimaryKey(SysResource record);

    List<SysResource> getResourceListByIdentify(String corporateIdentify);
}
