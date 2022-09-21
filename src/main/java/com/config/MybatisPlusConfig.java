package com.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;
//import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Optional;


/**
 * @Classname: MybatisPlusConfig
 * @Date: 2022/9/20 下午 06:19
 * @Author: kalam_au
 * @Description:
 */


@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    private static final Logger log = LogManager.getLogger(MybatisPlusConfig.class.getName());

    private final DataSource dataSource;
    private final MybatisProperties properties;
    private final ResourceLoader resourceLoader;
    private Interceptor[] interceptors;
    private DatabaseIdProvider databaseIdProvider;
    private final MyMetaObjectHandlerConfig myMetaObjectHandlerConfig;


    @Autowired
    public MybatisPlusConfig(MyMetaObjectHandlerConfig myMetaObjectHandlerConfig, DataSource dataSource, MybatisProperties properties, ResourceLoader resourceLoader, Optional<Interceptor[]> interceptors, Optional<DatabaseIdProvider> databaseIdProvider) {
        this.myMetaObjectHandlerConfig = myMetaObjectHandlerConfig;
        this.dataSource = dataSource;
        this.properties = properties;
        this.resourceLoader = resourceLoader;
        interceptors.ifPresent(interceptorsOptional -> this.interceptors = interceptorsOptional);
        databaseIdProvider.ifPresent(databaseIdProviderOptional -> this.databaseIdProvider = databaseIdProviderOptional);
    }


    /**
     * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
     * 配置文件和mybatis-boot的配置文件同步
     *
     * @return
     */
    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {

        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
        mybatisPlus.setDataSource(dataSource);
        mybatisPlus.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            log.info("properties.getConfigLocation() => " + properties.getConfigLocation());
            mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        if (!ObjectUtils.isEmpty(this.interceptors)) {
            log.info("interceptors => " + Arrays.toString(interceptors));
            mybatisPlus.setPlugins(this.interceptors);
        }
        MybatisConfiguration mc = new MybatisConfiguration();
        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);

        //数据库字段设计为驼峰命名，默认开启的驼峰转下划线会报错字段找不到
        mc.setMapUnderscoreToCamelCase(false);
        mybatisPlus.setConfiguration(mc);
        if (this.databaseIdProvider != null) {
            log.info("databaseIdProvider => " + databaseIdProvider);
            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            log.info("properties.getTypeAliasesPackage() => " + properties.getTypeAliasesPackage());
            mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            log.info("properties.getTypeHandlersPackage() => " + properties.getTypeHandlersPackage());
            mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            log.info("properties.resolveMapperLocations() => " + Arrays.toString(properties.resolveMapperLocations()));
            mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
        }
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(myMetaObjectHandlerConfig);

        mybatisPlus.setGlobalConfig(globalConfig);
        return mybatisPlus;
    }


}

