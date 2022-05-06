package com.jtj;

import com.alibaba.fastjson.JSON;
import com.jtj.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortalSystemApplication {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyController.class);
    public static void main(String[] args) {
        SpringApplication.run(PortalSystemApplication.class, args);
        logger.info("启动成功");
    }

}
