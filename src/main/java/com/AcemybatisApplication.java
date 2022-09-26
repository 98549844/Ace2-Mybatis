package com;

import com.util.BeanUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan({"com", "com.config"})
@MapperScan("com.mapper")
public class AcemybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcemybatisApplication.class, args);
      //  BeanUtil.printBeanName(BeanUtil.getApplicationContext());
    }

}
