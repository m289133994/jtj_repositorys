package com.jtj.controller;

import com.jtj.model.SysUser;
import com.jtj.service.SysUserService;
import com.jtj.util.CodeStatus;
import com.jtj.util.Result;
import com.jtj.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/****
 * @Author: csh
 *****/

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyController.class);
    // 注入业务层对象
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(SysUser sysUser){
        if (sysUser ==null||sysUser.getName()==null||sysUser.getPwd()==null||sysUser.getCorporateIdentify()== null){
            return  new Result(CodeStatus.ERROR,"密码/用户名/标识不能为空");
        }
        SysUser parameter =new SysUser();
        parameter.setName(sysUser.getName());
        SysUser result = sysUserService.queryUserByParameter(parameter);
        if (result!=null){
            return new Result(CodeStatus.ERROR,"用户名重复,不能创建");
        }
        String saltPassword = ShiroUtil.saltPassword(sysUser.getPwd(),ShiroUtil.defaultSalt());
        sysUser.setPwd(saltPassword);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setStatus(1);//0:无效 1：有效
        sysUserService.insert(sysUser);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(SysUser sysUser){
        if (sysUser ==null||sysUser.getUserId() ==null ){
            return  new Result(CodeStatus.ERROR,"用户id不能为空");
        }
        sysUserService.update(sysUser);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    /*软删除*/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(SysUser sysUser){
        if (sysUser ==null||sysUser.getUserId() ==null ){
            return  new Result(CodeStatus.ERROR,"用户id不能为空");
        }
        SysUser parameter = new SysUser();
        parameter.setUserId(sysUser.getUserId());
        parameter.setUpdateTime(new Date());
        parameter.setStatus(0);//无效
        sysUserService.delete(sysUser);
        return new Result(CodeStatus.SUCCES,"操作成功！");
    }

    @RequestMapping("/queryById")
    public Object queryById(SysUser sysUser){
        if (sysUser ==null||sysUser.getUserId() ==null ){
            return  new Result(CodeStatus.ERROR,"用户id不能为空");
        }
        SysUser result = sysUserService.queryById(sysUser);
        return new Result(result);
    }

    @RequestMapping("/queryAll")
    public Object queryAll(){
        List<SysUser> sysUsers = sysUserService.queryAll();
        return new Result(sysUsers);
    }

    //登录
    @PostMapping("/login")
    public Object login(String username, String password,String corporateIdentify){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录的方法，如果没有异常，就登录ok
            SysUser parameter = new SysUser();
            parameter.setName(username);
            SysUser sysUser = sysUserService.queryUserByParameter(parameter);
            if (sysUser !=null &&sysUser.getCorporateIdentify().equals(corporateIdentify)){
                return new Result(CodeStatus.SUCCES,"登录成功");
            }
            return new Result(CodeStatus.ERROR,"用户名/密码/企业标识不正确");
        } catch (IncorrectCredentialsException e){
            return new Result(CodeStatus.ERROR,"用户名/密码/企业标识不正确");
        }catch (UnknownAccountException e){
            return new Result(CodeStatus.ERROR,"用户名/密码/企业标识不正确");
        }
    }

    //设置未登录时的返回信息
    @PostMapping("/unAuthor")
    @ResponseBody
    public Object unauthorized(){
        return new Result(CodeStatus.ERROR,"用户未登录");
    }

    //登出
    @PostMapping("/logout")
    public Object logout(){
        //退出操作，获取当前用户，执行logout即可
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result(CodeStatus.SUCCES,"登出成功");
    }
}
