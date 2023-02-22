//package com.ace2.mybatis.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import com.ace2.mybatis.util.RandomUtil;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDateTime;
//
///**
// * @Classname: MybatisConfig
// * @Date: 2022/9/20 上午 10:59
// * @Author: kalam_au
// * @Description:
// */
//
//@Configuration
//public class MyMetaObjectHandlerConfig implements MetaObjectHandler {
//    private static final Logger log = LogManager.getLogger(MyMetaObjectHandlerConfig.class.getName());
//
//    //https://blog.csdn.net/weixin_45875534/article/details/125311312
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        log.info("start update fill ....");
//        try {
//            Long userId = Long.valueOf(RandomUtil.getRangeInt(1, 100));
//
//            this.strictUpdateFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
//            this.strictUpdateFill(metaObject, "lastUpdatedBy", Long.class, userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        log.info("start insert fill ....");
//        try {
//            LocalDateTime now = LocalDateTime.now();
//            Long userId = Long.valueOf(RandomUtil.getRangeInt(1, 100));
//
//            this.strictUpdateFill(metaObject, "createdDate", LocalDateTime.class, now);
//            this.strictUpdateFill(metaObject, "createdBy", Long.class, userId);
//            this.strictUpdateFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
//            this.strictUpdateFill(metaObject, "lastUpdatedBy", Long.class, userId);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
//
//
//}
//
