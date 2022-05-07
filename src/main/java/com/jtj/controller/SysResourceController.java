package com.jtj.controller;

import com.jtj.model.SysResource;
import com.jtj.model.SysUser;
import com.jtj.service.SysIdentifyResourceService;
import com.jtj.service.SysResourceService;
import com.jtj.util.CodeStatus;
import com.jtj.util.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/****
 * @Author: csh
 *****/

@RestController
@RequestMapping("/sysResource")
public class SysResourceController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyController.class);
    // 注入业务层对象
    @Autowired
    private SysResourceService sysResourceService;
    @Autowired
    private SysIdentifyResourceService sysIdentifyResourceService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(SysResource sysResource){
        if (sysResource ==null||sysResource.getResourceName()==null){
            return  new Result(CodeStatus.ERROR,"菜单名称不能为空");
        }
        sysResource.setCreateTime(new Date());
        sysResource.setUpdateTime(new Date());
        sysResource.setStatus(1);//0:无效 1：有效
        sysResourceService.insert(sysResource);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(SysResource sysResource){
        if (sysResource ==null||sysResource.getResourceId() ==null ){
            return  new Result(CodeStatus.ERROR,"主键id不能为空");
        }
        sysResourceService.update(sysResource);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    /*软删除*/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(SysResource sysResource){
        if (sysResource ==null||sysResource.getResourceId() ==null ){
            return  new Result(CodeStatus.ERROR,"主键id不能为空");
        }
        SysResource parameter = new SysResource();
        parameter.setResourceId(sysResource.getResourceId());
        parameter.setUpdateTime(new Date());
        parameter.setStatus(0);//无效
        sysResourceService.delete(sysResource);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    @RequestMapping("/queryById")
    public Object queryById(SysResource sysResource){
        if (sysResource ==null||sysResource.getResourceId() ==null ){
            return  new Result(CodeStatus.ERROR,"主键id不能为空");
        }
        SysResource result = sysResourceService.queryById(sysResource);
        return new Result(result);
    }

    @RequestMapping("/queryAll")
    public Object queryAll(){
        List<SysResource> sysResources = sysResourceService.queryAll();
        return new Result(sysResources);
    }

    //通过企业标识获取菜单数据
    @RequestMapping("/getResourceByIdentify")
    public Object getResourceByIdentify(){
        //从shiro的session中取出当前用户信息
        SysUser sysUser = (SysUser)SecurityUtils.getSubject().getSession().getAttribute("sysUser");
        List<SysResource> resourceListByIdentify = sysResourceService.getResourceListByIdentify(sysUser.getCorporateIdentify());
        return new Result(resourceListByIdentify);
    }
}
