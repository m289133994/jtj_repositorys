package com.jtj.config;

/*import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;*/
import com.jtj.filter.ShiroUserFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author csh
 * @date 2019/11/16 16:26:32
 * @description
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //设置未登录或者登录失效时返回的json
        Map<String,Filter> filterMap =new HashMap<>();
        filterMap.put("authc",new ShiroUserFilter());
        bean.setFilters(filterMap);
        //添加shiro的内置管理器
        /**
         * anon：无需认证即可访问
         * authc：必须认证才能访问
         * user：必须拥有 记住我 功能
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        //拦截
        Map<String, String> filter = new LinkedHashMap<>();
        filter.put("/sysUser/**","anon");
        filter.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filter);
        //设置登录的请求
        //bean.setLoginUrl("/sysUser/login");
        //设置未授权请求页面
        //bean.setUnauthorizedUrl("/sysUser/unAuthor");
        return bean;
    }

    //DefaultWebSecurityManager 2.
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm类，自定义 1.
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect 用于thymeleaf和shiro标签配合使用
    /*@Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }*/
}
