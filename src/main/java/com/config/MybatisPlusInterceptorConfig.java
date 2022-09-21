package com.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: MybatisPlusInterceptor
 * @Date: 2022/9/20 下午 07:05
 * @Author: kalam_au
 * @Description:
 */

@Configuration
public class MybatisPlusInterceptorConfig {
    private static final Logger log = LogManager.getLogger(MybatisPlusInterceptorConfig.class.getName());


    /**
     * 乐观锁
     * version + 1
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        log.info("Version => 乐观锁 !!!");
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}

