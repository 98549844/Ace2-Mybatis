package com.ace2.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.ace2.mybatis", "com.ace2.mybatis.config"})
@MapperScan("com.ace2.mybatis.mapper")
public class AceMybatisApplication {

    private static final Logger log = LogManager.getLogger(AceMybatisApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(AceMybatisApplication.class, args);
      //  BeanUtil.printBeanName(BeanUtil.getApplicationContext());

        log.info("Application startup complete !!!");

    }

}
