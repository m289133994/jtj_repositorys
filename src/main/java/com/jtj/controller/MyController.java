package com.jtj.controller;

import com.alibaba.fastjson.JSON;
import com.jtj.model.User;
import com.jtj.service.UserService;
import com.jtj.util.Result;
import com.jtj.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author csh
 * @date 2019/11/16 11:32:13
 * @description
 */
//测试代码，可以直接删除或者忽略
@Controller
public class MyController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyController.class);
    @Autowired
    private UserService userService;
    @RequestMapping({"/","/index","/index.html"})
    public String toIndex(Model model){
        return "index";
    }
    @RequestMapping("/user/{handle}")
    public String add(@PathVariable("handle") String handle){
        return "user/" + handle;
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
            return "register";
    }
    @PostMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录的方法，如果没有异常，就登录ok
            return "index";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg", "密码不正确");
            return "login";
        }catch (UnknownAccountException e){
            model.addAttribute("msg", "用户名不正确");
            return "login";
        }
    }
    @RequestMapping("/unAuthor")
    @ResponseBody
    public String unauthorized(){
        return "未经授权，无法访问此页面";
    }
    @RequestMapping("/logout")
    public String logout(){
        //退出操作，获取当前用户，执行logout即可
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
    @PostMapping("/register")
    public String register(String username, String password){
        String saltValue = ShiroUtil.createSalt();
        String saltPassword = ShiroUtil.saltPassword(password,saltValue);
        User user = new User();
        user.setName(username);
        user.setPwd(saltPassword);
        user.setSaltValue(saltValue);
        user.setPerms("user:add");
        logger.info("user信息是:"+JSON.toJSONString(user));
        userService.insertUser(user);
        return "redirect:/index.html";
    }


    @RequestMapping("/test")
    @ResponseBody
    public Result test(){

        ArrayList<String> result = new ArrayList<>();
        result.add("测试一下");
        result.add("测试两下");
        User user = userService.queryUserByName("2");
        return  new Result(user);
    }
}
