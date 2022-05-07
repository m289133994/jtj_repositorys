package com.jtj;

import com.jtj.model.SysUser;
import com.jtj.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortalSystemApplicationTests {
    @Autowired
    private SysUserService sysUserService;
    @Test
    void contextLoads() {
        SysUser user= new SysUser();
        user.setName("1");
        user.setPwd("2");
        SysUser sysUser = sysUserService.queryUserByParameter(user);
    }

}
